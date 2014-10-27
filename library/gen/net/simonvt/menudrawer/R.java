/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * aapt tool from the resource data it found.  It
 * should not be modified by hand.
 */

package net.simonvt.menudrawer;

public final class R {
    public static final class attr {
        /**  Drawable used as indicator for the active view. 
         <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static int mdActiveIndicator=0x7f010004;
        /**  Drawable to use for the background of the content. 
         <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static int mdContentBackground=0x7f010001;
        /**  Drawable used for the drop shadow. 
         <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static int mdDropShadow=0x7f010008;
        /**  The color of the drop shadow. Default is #FF000000. 
         <p>Must be a color value, in the form of "<code>#<i>rgb</i></code>", "<code>#<i>argb</i></code>",
"<code>#<i>rrggbb</i></code>", or "<code>#<i>aarrggbb</i></code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static int mdDropShadowColor=0x7f010007;
        /**  Defines whether the content will have a dropshadow onto the menu. Default is true. 
         <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static int mdDropShadowEnabled=0x7f010005;
        /**  The size of the drop shadow. Default is 6dp 
         <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static int mdDropShadowSize=0x7f010006;
        /**  Drawable to use for the background of the menu. 
         <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static int mdMenuBackground=0x7f010002;
        /**  The size of the menu. 
         <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static int mdMenuSize=0x7f010003;
        /**  The touch bezel size. 
         <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static int mdTouchBezelSize=0x7f010009;
        /**  Reference to a style for the menu drawer. 
         <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static int menuDrawerStyle=0x7f010000;
    }
    public static final class color {
        /**  The default background of the menu. 
         */
        public static int md__defaultBackground=0x7f020000;
    }
    public static final class id {
        /**  Used with View#setTag(int) to specify a position for the active view. 
         */
        public static int mdActiveViewPosition=0x7f030005;
        /**  ID used when defining the content layout in XML. 
         */
        public static int mdContent=0x7f030000;
        /**  ID used when defining the menu layout in XML. 
         */
        public static int mdMenu=0x7f030001;
        /**  The ID of the content container. 
         */
        public static int md__content=0x7f030002;
        /**  The ID of the drawer. 
         */
        public static int md__drawer=0x7f030004;
        /**  The ID of the menu container. 
         */
        public static int md__menu=0x7f030003;
    }
    public static final class style {
        public static int Widget=0x7f040000;
        /**  Base theme for the menu drawer. 
         */
        public static int Widget_MenuDrawer=0x7f040001;
    }
    public static final class styleable {
        /**  Styleables used for styling the menu drawer. 
           <p>Includes the following attributes:</p>
           <table>
           <colgroup align="left" />
           <colgroup align="left" />
           <tr><th>Attribute</th><th>Description</th></tr>
           <tr><td><code>{@link #MenuDrawer_mdActiveIndicator net.simonvt.menudrawer:mdActiveIndicator}</code></td><td> Drawable used as indicator for the active view.</td></tr>
           <tr><td><code>{@link #MenuDrawer_mdContentBackground net.simonvt.menudrawer:mdContentBackground}</code></td><td> Drawable to use for the background of the content.</td></tr>
           <tr><td><code>{@link #MenuDrawer_mdDropShadow net.simonvt.menudrawer:mdDropShadow}</code></td><td> Drawable used for the drop shadow.</td></tr>
           <tr><td><code>{@link #MenuDrawer_mdDropShadowColor net.simonvt.menudrawer:mdDropShadowColor}</code></td><td> The color of the drop shadow.</td></tr>
           <tr><td><code>{@link #MenuDrawer_mdDropShadowEnabled net.simonvt.menudrawer:mdDropShadowEnabled}</code></td><td> Defines whether the content will have a dropshadow onto the menu.</td></tr>
           <tr><td><code>{@link #MenuDrawer_mdDropShadowSize net.simonvt.menudrawer:mdDropShadowSize}</code></td><td> The size of the drop shadow.</td></tr>
           <tr><td><code>{@link #MenuDrawer_mdMenuBackground net.simonvt.menudrawer:mdMenuBackground}</code></td><td> Drawable to use for the background of the menu.</td></tr>
           <tr><td><code>{@link #MenuDrawer_mdMenuSize net.simonvt.menudrawer:mdMenuSize}</code></td><td> The size of the menu.</td></tr>
           <tr><td><code>{@link #MenuDrawer_mdTouchBezelSize net.simonvt.menudrawer:mdTouchBezelSize}</code></td><td> The touch bezel size.</td></tr>
           </table>
           @see #MenuDrawer_mdActiveIndicator
           @see #MenuDrawer_mdContentBackground
           @see #MenuDrawer_mdDropShadow
           @see #MenuDrawer_mdDropShadowColor
           @see #MenuDrawer_mdDropShadowEnabled
           @see #MenuDrawer_mdDropShadowSize
           @see #MenuDrawer_mdMenuBackground
           @see #MenuDrawer_mdMenuSize
           @see #MenuDrawer_mdTouchBezelSize
         */
        public static final int[] MenuDrawer = {
            0x7f010001, 0x7f010002, 0x7f010003, 0x7f010004,
            0x7f010005, 0x7f010006, 0x7f010007, 0x7f010008,
            0x7f010009
        };
        /**
          <p>
          @attr description
           Drawable used as indicator for the active view. 


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          <p>This is a private symbol.
          @attr name android:mdActiveIndicator
        */
        public static final int MenuDrawer_mdActiveIndicator = 3;
        /**
          <p>
          @attr description
           Drawable to use for the background of the content. 


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          <p>This is a private symbol.
          @attr name android:mdContentBackground
        */
        public static final int MenuDrawer_mdContentBackground = 0;
        /**
          <p>
          @attr description
           Drawable used for the drop shadow. 


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          <p>This is a private symbol.
          @attr name android:mdDropShadow
        */
        public static final int MenuDrawer_mdDropShadow = 7;
        /**
          <p>
          @attr description
           The color of the drop shadow. Default is #FF000000. 


          <p>Must be a color value, in the form of "<code>#<i>rgb</i></code>", "<code>#<i>argb</i></code>",
"<code>#<i>rrggbb</i></code>", or "<code>#<i>aarrggbb</i></code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          <p>This is a private symbol.
          @attr name android:mdDropShadowColor
        */
        public static final int MenuDrawer_mdDropShadowColor = 6;
        /**
          <p>
          @attr description
           Defines whether the content will have a dropshadow onto the menu. Default is true. 


          <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          <p>This is a private symbol.
          @attr name android:mdDropShadowEnabled
        */
        public static final int MenuDrawer_mdDropShadowEnabled = 4;
        /**
          <p>
          @attr description
           The size of the drop shadow. Default is 6dp 


          <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          <p>This is a private symbol.
          @attr name android:mdDropShadowSize
        */
        public static final int MenuDrawer_mdDropShadowSize = 5;
        /**
          <p>
          @attr description
           Drawable to use for the background of the menu. 


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          <p>This is a private symbol.
          @attr name android:mdMenuBackground
        */
        public static final int MenuDrawer_mdMenuBackground = 1;
        /**
          <p>
          @attr description
           The size of the menu. 


          <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          <p>This is a private symbol.
          @attr name android:mdMenuSize
        */
        public static final int MenuDrawer_mdMenuSize = 2;
        /**
          <p>
          @attr description
           The touch bezel size. 


          <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          <p>This is a private symbol.
          @attr name android:mdTouchBezelSize
        */
        public static final int MenuDrawer_mdTouchBezelSize = 8;
    };
}
