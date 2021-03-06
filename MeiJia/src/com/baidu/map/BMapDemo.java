package com.baidu.map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.*;
import com.baidu.mapapi.navi.BaiduMapAppNotSupportNaviException;
import com.baidu.mapapi.navi.BaiduMapNavigation;
import com.baidu.mapapi.navi.NaviPara;
import com.baidu.mapapi.search.*;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.huewu.pla.sample.R;
import com.baidu.location.LocationClientOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BMapDemo extends Activity {
	private MapView mMapView = null;
	private MKSearch mSearch = null;
	public MyLocationListenner myListener = new MyLocationListenner();
	// 定位图层
	locationOverlay myLocationOverlay = null;
	private MapController mMapController = null;
	Button requestLocButton = null, btnSearch = null, btnnavigation = null,
			btnWalk = null, btnDriver = null, btnBus;
	ImageButton btnDetail = null;
	LocationClient mLocClient;
	LocationData locData = null;
	private DemoApplication app;
	// private AutoCompleteTextView keyWorldsView = null;
	// private ArrayAdapter<String> sugAdapter = null;
	private final String CITY = "厦门";
	private GeoPoint start, end;
	private ListView listView;
	private SimpleAdapter adapter;
	private List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
	private MKPoiInfo info;
	RouteOverlay routeOverlay;
	TransitOverlay transitOverlay;
	TextView time, diastance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		app = (DemoApplication) this.getApplication();
		if (app.mBMapManager == null) {
			app.mBMapManager = new BMapManager(this);
			app.mBMapManager.init(DemoApplication.strKey,
					new DemoApplication.MyGeneralListener());
		}
		setContentView(R.layout.activity_bampdemo);
		btnWalk = (Button) findViewById(R.id.walk);
		btnDriver = (Button) findViewById(R.id.drive);
		requestLocButton = (Button) findViewById(R.id.button1);
		btnSearch = (Button) findViewById(R.id.search);
		btnnavigation = (Button) findViewById(R.id.navigation);
		btnDetail = (ImageButton) findViewById(R.id.detail);
		btnBus = (Button) findViewById(R.id.bus);
		// keyWorldsView = (AutoCompleteTextView) findViewById(R.id.searchkey);
		listView = (ListView) findViewById(R.id.RoutesListView);
		time = (TextView) findViewById(R.id.txt_time);
		diastance = (TextView) findViewById(R.id.txt_diatatnce);

		// sugAdapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_dropdown_item_1line);
		// keyWorldsView.setAdapter(sugAdapter);
		requestLocButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				requestLocClick();
			}
		});
		btnnavigation.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				start = new GeoPoint((int) (locData.latitude * 1e6),
						(int) (locData.longitude * 1e6));
				startNavi(start, end);
			}
		});
		btnDetail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (info != null && info.uid != null) {
					mSearch.poiDetailSearch(info.uid);
				}
			}
		});
		// keyWorldsView.addTextChangedListener(new TextWatcher() {
		//
		// @Override
		// public void afterTextChanged(Editable arg0) {
		//
		// }
		//
		// @Override
		// public void beforeTextChanged(CharSequence arg0, int arg1,
		// int arg2, int arg3) {
		// }
		//
		// @Override
		// public void onTextChanged(CharSequence cs, int arg1, int arg2,
		// int arg3) {
		// if (cs.length() <= 0) {
		// return;
		// }
		// /**
		// * 使用建议搜索服务获取建议列表，结果在onSuggestionResult()中更新
		// */
		// mSearch.suggestionSearch(cs.toString(), CITY);
		// }
		// });

		adapter = new SimpleAdapter(this, data,
				R.layout.listitem_navigator_result, new String[] { "val" },
				new int[] { R.id.tvResult });

		listView.setAdapter(adapter);
		// 地图初始化
		initMap();
		// 定位初始化
		initLocation();
		// 搜索初始化
		initsetSearch();
		// 初始化AutoTextView

		btnWalk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (end == null) {
					Toast.makeText(getApplicationContext(), "无终点",
							Toast.LENGTH_SHORT).show();
					return;
				}
				MKPlanNode mStart = new MKPlanNode();
				MKPlanNode mEnd = new MKPlanNode();
				mStart.pt = start;
				mEnd.pt = end;
				if (routeOverlay != null) {
					mMapView.getOverlays().remove(routeOverlay);
				}
				mSearch.walkingSearch(null, mStart, null, mEnd);
			}
		});

		btnBus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (end == null) {
					Toast.makeText(getApplicationContext(), "无终点",
							Toast.LENGTH_SHORT).show();
					return;
				}
				MKPlanNode mStart = new MKPlanNode();
				MKPlanNode mEnd = new MKPlanNode();
				mStart.pt = start;
				mEnd.pt = end;
				if (transitOverlay != null) {
					mMapView.getOverlays().remove(transitOverlay);
				}
				mSearch.transitSearch("厦门", mStart, mEnd);
			}
		});
		btnDriver.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (end == null) {
					Toast.makeText(getApplicationContext(), "无终点",
							Toast.LENGTH_SHORT).show();
					return;
				}
				MKPlanNode mStart = new MKPlanNode();
				MKPlanNode mEnd = new MKPlanNode();
				mStart.pt = start;
				mEnd.pt = end;
				if (routeOverlay != null) {
					mMapView.getOverlays().remove(routeOverlay);
				}
				mSearch.drivingSearch(null, mStart, null, mEnd);
			}
		});

	}

	private void initMap() {
		mMapView = (MapView) findViewById(R.id.bmapView);
		mMapController = mMapView.getController();
		mMapView.getController().setZoom(16);
		mMapView.getController().enableClick(true);
		mMapView.setBuiltInZoomControls(true);
		ZoomControls zoomControls = (ZoomControls) mMapView.getChildAt(2);
		zoomControls.setVisibility(View.GONE);
		// zoomControls.setPadding(0, 0, 0, 90);
	}

	private void initLocation() {
		mLocClient = new LocationClient(this);
		locData = new LocationData();
		// 定位图层初始化
		myLocationOverlay = new locationOverlay(mMapView);
		mLocClient.registerLocationListener(myListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(5000);
		mLocClient.setLocOption(option);
		mLocClient.start();
		// 设置定位数据
		myLocationOverlay.setData(locData);
		// 添加定位图层
		mMapView.getOverlays().add(myLocationOverlay);
		myLocationOverlay.enableCompass();
		// 修改定位数据后刷新图层生效
		mMapView.refresh();
	}

	private void initsetSearch() {
		mSearch = new MKSearch();
		mSearch.init(app.mBMapManager, new MKSearchListener() {
			// 在此处理详情页结果
			@Override
			public void onGetPoiDetailSearchResult(int type, int error) {
				if (error != 0) {
					Toast.makeText(BMapDemo.this, "抱歉，未找到结果",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(BMapDemo.this, "成功，查看详情页面",
							Toast.LENGTH_SHORT).show();
				}
			}

			/**
			 * 在此处理poi搜索结果
			 */
			public void onGetPoiResult(MKPoiResult res, int type, int error) {
				// 错误号可参考MKEvent中的定义
				if (error != 0 || res == null) {
					Toast.makeText(BMapDemo.this, "抱歉，未找到结果", Toast.LENGTH_LONG)
							.show();
					return;
				}
				// 将地图移动到第一个POI中心点
				if (res.getCurrentNumPois() > 0) {
					// 将poi结果显示到地图上
					MyPoiOverlayTest poiOverlay = new MyPoiOverlayTest(
							BMapDemo.this, mMapView, mSearch);
					poiOverlay.setData(res.getAllPoi());
					mMapView.getOverlays().clear();
					myLocationOverlay.setData(locData);
					mMapView.getOverlays().add(myLocationOverlay);
					mMapView.getOverlays().add(poiOverlay);
					mMapView.refresh();
					// 当ePoiType为2（公交线路）或4（地铁线路）时， poi坐标为空
					for (MKPoiInfo info : res.getAllPoi()) {
						if (info.pt != null) {
							mMapView.getController().animateTo(info.pt);
							break;
						}
					}
				} else if (res.getCityListNum() > 0) {
					// 当输入关键字在本市没有找到，但在其他城市找到时，返回包含该关键字信息的城市列表
					String strInfo = "在";
					for (int i = 0; i < res.getCityListNum(); i++) {
						strInfo += res.getCityListInfo(i).city;
						strInfo += ",";
					}
					strInfo += "找到结果";
					Toast.makeText(BMapDemo.this, strInfo, Toast.LENGTH_LONG)
							.show();
				}
			}

			public void onGetDrivingRouteResult(MKDrivingRouteResult res,
					int error) {

				if (error != 0 || res == null) {
					Toast.makeText(BMapDemo.this, "抱歉，未找到结果", Toast.LENGTH_LONG)
							.show();
					return;
				}
				routeOverlay = new RouteOverlay(BMapDemo.this, mMapView);
				routeOverlay.setData(res.getPlan(0).getRoute(0));
				mMapView.getOverlays().add(routeOverlay);
				mMapView.refresh();
				mMapView.getController().zoomToSpan(
						routeOverlay.getLatSpanE6(),
						routeOverlay.getLonSpanE6());
				mMapView.getController().animateTo(res.getStart().pt);
				MKRoutePlan plan = res.getPlan(0);

				data.clear();

				for (int i = 0; i < plan.getNumRoutes(); i++) {
					MKRoute route = plan.getRoute(i);
					for (int j = 0; j < route.getNumSteps(); j++) {
						MKStep curStep = route.getStep(j);
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("val", curStep.getContent());
						data.add(map);
					}
				}
				time.setText("时间" + plan.getTime() / 60 + "分钟");
				diastance.setText("距离" + plan.getDistance() + "米");
				adapter.notifyDataSetChanged();
				listView.setVisibility(View.VISIBLE);
			}

			public void onGetTransitRouteResult(MKTransitRouteResult res,
					int error) {
				if (error != 0 || res == null) {
					Toast.makeText(BMapDemo.this, "抱歉，未找到结果", Toast.LENGTH_LONG)
							.show();
					return;
				}
				transitOverlay = new TransitOverlay(BMapDemo.this, mMapView);
				// 展示其中一个换乘方案
				transitOverlay.setData(res.getPlan(0));
				// 在地图上显示
				mMapView.getOverlays().add(transitOverlay);
				mMapView.refresh();
				mMapView.getController().zoomToSpan(
						transitOverlay.getLatSpanE6(),
						transitOverlay.getLonSpanE6());
				mMapView.getController().animateTo(res.getStart().pt);
				MKTransitRoutePlan plan = res.getPlan(0);

				time.setText("时间" + plan.getTime() / 60 + "分钟");
				diastance.setText("距离" + plan.getDistance() + "米");
				adapter.notifyDataSetChanged();
				listView.setVisibility(View.VISIBLE);
			}

			public void onGetWalkingRouteResult(MKWalkingRouteResult res,
					int error) {
				if (error != 0 || res == null) {
					Toast.makeText(BMapDemo.this, "抱歉，未找到结果", Toast.LENGTH_LONG)
							.show();
					return;
				}
				routeOverlay = new RouteOverlay(BMapDemo.this, mMapView);
				routeOverlay.setData(res.getPlan(0).getRoute(0));

				mMapView.getOverlays().add(routeOverlay);
				mMapView.refresh();
				mMapView.getController().zoomToSpan(
						routeOverlay.getLatSpanE6(),
						routeOverlay.getLonSpanE6());
				mMapView.getController().animateTo(res.getStart().pt);

				MKRoutePlan plan = res.getPlan(0);

				data.clear();

				for (int i = 0; i < plan.getNumRoutes(); i++) {
					MKRoute route = plan.getRoute(i);
					for (int j = 0; j < route.getNumSteps(); j++) {
						MKStep curStep = route.getStep(j);
						String ste = curStep.getContent();
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("val", curStep.getContent());
						data.add(map);
					}
				}
				time.setText("时间" + plan.getTime() / 60 + "分钟");
				diastance.setText("距离" + plan.getDistance() + "米");
				adapter.notifyDataSetChanged();
				listView.setVisibility(View.VISIBLE);
			}

			public void onGetAddrResult(MKAddrInfo res, int error) {
			}

			public void onGetBusDetailResult(MKBusLineResult result, int iError) {
				if (iError != 0 || result == null) {
					Toast.makeText(BMapDemo.this, "抱歉，未找到结果", Toast.LENGTH_LONG)
							.show();
					return;
				}

			}

			/**
			 * 更新建议列表
			 */
			@Override
			public void onGetSuggestionResult(MKSuggestionResult res, int arg1) {
				if (res == null || res.getAllSuggestions() == null) {
					return;
				}
				// sugAdapter.clear();
				// for (MKSuggestionInfo info : res.getAllSuggestions()) {
				// if (info.key != null)
				// sugAdapter.add(info.key);
				// }
				// sugAdapter.notifyDataSetChanged();

			}

			@Override
			public void onGetShareUrlResult(MKShareUrlResult result, int type,
					int error) {
				// TODO Auto-generated method stub

			}
		});

	}

	/**
	 * 影响搜索按钮点击事件
	 *
	 * @param
	 */
	public void searchButtonProcess() {
		GeoPoint pt = new GeoPoint((int) (locData.latitude * 1e6),
				(int) (locData.longitude * 1e6));
		mSearch.poiSearchNearBy("美甲", pt, 1000);
	}

	/**
	 * 定位SDK监听函数
	 */
	public class MyLocationListenner implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null)
				return;

			locData.latitude = location.getLatitude();
			locData.longitude = location.getLongitude();
			// 如果不显示定位精度圈，将accuracy赋值为0即可
			locData.accuracy = location.getRadius();
			locData.direction = location.getDerect();
			start = new GeoPoint((int) (locData.latitude * 1e6),
					(int) (locData.longitude * 1e6));
			// 更新定位数据
			myLocationOverlay.setData(locData);
			// 更新图层数据执行刷新后生效
			mMapView.refresh();
			// 是手动触发请求或首次定位时，移动到定位点
			// 移动地图到定位点
			mMapController.animateTo(new GeoPoint(
					(int) (locData.latitude * 1e6),
					(int) (locData.longitude * 1e6)));

			Log.i("X", (int) (locData.latitude * 1e6) + "");
			Log.i("Y", (int) (locData.longitude * 1e6) + "");
			searchButtonProcess();
		}

		public void onReceivePoi(BDLocation poiLocation) {
			if (poiLocation == null) {
				return;
			}
		}
	}

	public class MyPoiOverlayTest extends PoiOverlay {

		MKSearch mSearch;

		public MyPoiOverlayTest(Activity activity, MapView mapView,
				MKSearch search) {
			super(activity, mapView);
			mSearch = search;
		}

		int index = -1;

		@Override
		protected boolean onTap(int i) {
			super.onTap(i);
			info = getPoi(i);
			end = info.pt;
			LinearLayout ly = (LinearLayout) findViewById(R.id.ly);
			ly.setVisibility(View.GONE);
			ly.setVisibility(View.VISIBLE);
			TextView tx = (TextView) findViewById(R.id.title);
			tx.setText(info.name);
			return true;
		}
	}

	public void requestLocClick() {
		mLocClient.requestLocation();
		Toast.makeText(BMapDemo.this, "正在定位……", Toast.LENGTH_SHORT).show();
	}

	/**
	 * 开始导航
	 *
	 * @param
	 */
	public void startNavi(GeoPoint start, GeoPoint end) {

		// 构建 导航参数
		NaviPara para = new NaviPara();
		para.startPoint = start;
		para.startName = "从这里开始";
		para.endPoint = end;
		para.endName = "到这里结束";

		try {

			BaiduMapNavigation.openBaiduMapNavi(para, this);

		} catch (BaiduMapAppNotSupportNaviException e) {
			e.printStackTrace();
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("您尚未安装百度地图app或app版本过低，点击确认安装？");
			builder.setTitle("提示");
			builder.setPositiveButton("确认",
					new android.content.DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
							BaiduMapNavigation
									.GetLatestBaiduMapApp(BMapDemo.this);
						}
					});

			builder.setNegativeButton("取消",
					new android.content.DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});

			builder.create().show();
		}
	}

	// 继承MyLocationOverlay重写dispatchTap实现点击处理
	public class locationOverlay extends MyLocationOverlay {

		public locationOverlay(MapView mapView) {
			super(mapView);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected boolean dispatchTap() {
			// TODO Auto-generated method stub
			// 处理点击事件,弹出泡泡
			return true;
		}

	}

	@Override
	protected void onPause() {
		mMapView.onPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		mMapView.onResume();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		mMapView.destroy();
		super.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mMapView.onSaveInstanceState(outState);

	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		mMapView.onRestoreInstanceState(savedInstanceState);
	}

}
