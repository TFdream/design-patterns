## 建造者模式(Builder Pattern)
### 前言
无论是在现实世界中还是在软件系统中，都存在一些复杂的对象，它们拥有多个组成部分，如汽车，它包括车轮、方向盘、发动机等各种部件。而对于大多数用户而言，无须知道这些部件的装配细节，也几乎不会使用单独某个部件，而是使用一辆完整的汽车，可以通过建造者模式对其进行设计与描述，建造者模式可以将部件和其组装过程分开，一步一步创建一个复杂的对象。用户只需要指定复杂对象的类型就可以得到该对象，而无须知道其内部的具体构造细节。

在软件开发中，也存在大量类似汽车一样的复杂对象，它们拥有一系列成员属性，这些成员属性中有些是引用类型的成员对象。而且在这些复杂对象中，还可能存在一些限制条件，如某些属性没有赋值则复杂对象不能作为一个完整的产品使用；有些属性的赋值必须按照某个顺序，一个属性没有赋值之前，另一个属性可能无法赋值等。

复杂对象相当于一辆有待建造的汽车，而对象的属性相当于汽车的部件，建造产品的过程就相当于组合部件的过程。由于组合部件的过程很复杂，因此，这些部件的组合过程往往被“外部化”到一个称作建造者的对象里，建造者返还给客户端的是一个已经建造完毕的完整产品对象，而用户无须关心该对象所包含的属性以及它们的组装方式，这就是建造者模式的模式动机。
### 模式定义
将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

<br>
### 模式结构
建造者模式包含如下角色：<br>
* Builder：抽象建造者接口，定义创建一个Product对象所需的各个部件的操作。
* ConcreteBuilder：具体的建造者实现，实现各个部件的创建，并负责组装Product对象的各个部件，同时还提供一个让用户获取组装完成后的产品对象的方法。
* Director：指挥者，统一Product组装过程(可省略)。
* Product：产品，表示被建造者构建的复杂对象，包含多个部件。

![GitHub](http://images.cnblogs.com/cnblogs_com/feipeng/Pic11.jpg "Builder Pic")

###代码示例
[示例1：电脑组装](../../design-patterns/src/main/java/com/ricky/designpattern/builder/ComputerBuildDemo.java)<br>
[示例2：汽车组装](../../design-patterns/src/main/java/com/ricky/designpattern/builder/CarDemo.java)<br>
[示例3：PersonBuilder](../../design-patterns/src/main/java/com/ricky/designpattern/builder/PersonBuilderDemo.java)<br>
[示例4：IVR SDK示例](../../design-patterns/src/main/java/com/ricky/designpattern/builder/IvrEngineDemo.java)<br>

<br>

### OkHttp 源码中的Builder模式实现
在[Square OkHttp](https://github.com/square/okhttp) 中，经常用到的Builder模式就是[Request.Builder](https://github.com/square/okhttp/blob/parent-3.4.0/okhttp/src/main/java/okhttp3/Request.java)，通过它来构造Request请求对象，如下：
```
OkHttpClient client = new OkHttpClient();

String run(String url) throws IOException {
  Request request = new Request.Builder()
      .url(url)
      .build();

  Response response = client.newCall(request).execute();
  return response.body().string();
}
```

下面是Request源码：
```
public final class Request {
  private final HttpUrl url;	//请求url
  private final String method;	//http请求类型,"GET"|"POST"|"DELETE"
  private final Headers headers;	//http请求头
  private final RequestBody body;	//请求体
  private final Object tag;

  private volatile CacheControl cacheControl; // Lazily initialized.

  // 1.构造函数
  private Request(Builder builder) {
    this.url = builder.url;
    this.method = builder.method;
    this.headers = builder.headers.build();
    this.body = builder.body;
    this.tag = builder.tag != null ? builder.tag : this;
  }

  public HttpUrl url() {
    return url;
  }

  public String method() {
    return method;
  }

  public Headers headers() {
    return headers;
  }

  public String header(String name) {
    return headers.get(name);
  }

  public List<String> headers(String name) {
    return headers.values(name);
  }

  public RequestBody body() {
    return body;
  }

  public Object tag() {
    return tag;
  }

  //省略其他代码......

  /**静态内部类Builder**/
  public static class Builder {
    private HttpUrl url;
    private String method;
    private Headers.Builder headers;
    private RequestBody body;
    private Object tag;

    public Builder() {
      this.method = "GET";
      this.headers = new Headers.Builder();
    }

    private Builder(Request request) {
      this.url = request.url;
      this.method = request.method;
      this.body = request.body;
      this.tag = request.tag;
      this.headers = request.headers.newBuilder();
    }

    public Builder url(HttpUrl url) {
      if (url == null) throw new NullPointerException("url == null");
      this.url = url;
      return this;
    }

    public Builder url(String url) {
      if (url == null) throw new NullPointerException("url == null");

      // Silently replace websocket URLs with HTTP URLs.
      if (url.regionMatches(true, 0, "ws:", 0, 3)) {
        url = "http:" + url.substring(3);
      } else if (url.regionMatches(true, 0, "wss:", 0, 4)) {
        url = "https:" + url.substring(4);
      }

      HttpUrl parsed = HttpUrl.parse(url);
      if (parsed == null) throw new IllegalArgumentException("unexpected url: " + url);
      return url(parsed);
    }

    public Builder url(URL url) {
      if (url == null) throw new NullPointerException("url == null");
      HttpUrl parsed = HttpUrl.get(url);
      if (parsed == null) throw new IllegalArgumentException("unexpected url: " + url);
      return url(parsed);
    }

    public Builder header(String name, String value) {
      headers.set(name, value);
      return this;
    }

    public Builder addHeader(String name, String value) {
      headers.add(name, value);
      return this;
    }

    public Builder removeHeader(String name) {
      headers.removeAll(name);
      return this;
    }

    public Builder headers(Headers headers) {
      this.headers = headers.newBuilder();
      return this;
    }

    public Builder cacheControl(CacheControl cacheControl) {
      String value = cacheControl.toString();
      if (value.isEmpty()) return removeHeader("Cache-Control");
      return header("Cache-Control", value);
    }

    public Builder get() {
      return method("GET", null);
    }

    public Builder head() {
      return method("HEAD", null);
    }

    public Builder post(RequestBody body) {
      return method("POST", body);
    }

    public Builder delete(RequestBody body) {
      return method("DELETE", body);
    }

    public Builder delete() {
      return delete(RequestBody.create(null, new byte[0]));
    }

    public Builder put(RequestBody body) {
      return method("PUT", body);
    }

    public Builder patch(RequestBody body) {
      return method("PATCH", body);
    }

    public Builder tag(Object tag) {
      this.tag = tag;
      return this;
    }
	
    // 调用new AlertDialog构造对象
    public Request build() {
      if (url == null) throw new IllegalStateException("url == null");	  
      return new Request(this);
    }
  }
}
```

Request.Builder类扮演Director与Builder双重角色。
<br>
### Android源码中的Builder模式实现
在Android源码中，最常用到的Builder模式就是AlertDialog.Builder， 使用该Builder来构建复杂的AlertDialog对象。如下 :
```
    //显示基本的AlertDialog  
    private void showDialog(Context context) {  
        AlertDialog.Builder builder = new AlertDialog.Builder(context);  
        builder.setIcon(R.drawable.icon);  
        builder.setTitle("Title");  
        builder.setMessage("Message");  
        builder.setPositiveButton("Button1",  
                new DialogInterface.OnClickListener() {  
                    public void onClick(DialogInterface dialog, int whichButton) {  
                        setTitle("点击了对话框上的Button1");  
                    }  
                });  
        builder.setNeutralButton("Button2",  
                new DialogInterface.OnClickListener() {  
                    public void onClick(DialogInterface dialog, int whichButton) {  
                        setTitle("点击了对话框上的Button2");  
                    }  
                });  
        builder.setNegativeButton("Button3",  
                new DialogInterface.OnClickListener() {  
                    public void onClick(DialogInterface dialog, int whichButton) {  
                        setTitle("点击了对话框上的Button3");  
                    }  
                });  
        builder.create().show();  // 构建AlertDialog， 并且显示
    } 
```

显示效果如下：<br>
![GitHub](https://github.com/simple-android-framework-exchange/android_design_patterns_analysis/raw/master/builder/mr.simple/images/result.png "Builder Pic")
<br>
Android AlertDialog 源码 :
```

// AlertDialog
public class AlertDialog extends Dialog implements DialogInterface {
    // Controller, 接受Builder成员变量P中的各个参数
    private AlertController mAlert;

    // 构造函数
    protected AlertDialog(Context context, int theme) {
        this(context, theme, true);
    }

    AlertDialog(Context context, int theme, boolean createContextWrapper) {
        super(context, resolveDialogTheme(context, theme), createContextWrapper);
        mWindow.alwaysReadCloseOnTouchAttr();
        mAlert = new AlertController(getContext(), this, getWindow());
    }

    // 实际上调用的是mAlert的setTitle方法
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        mAlert.setTitle(title);
    }

    // 实际上调用的是mAlert的setCustomTitle方法
    public void setCustomTitle(View customTitleView) {
        mAlert.setCustomTitle(customTitleView);
    }

    public void setMessage(CharSequence message) {
        mAlert.setMessage(message);
    }

    // AlertDialog其他的代码省略

    // ************  Builder为AlertDialog的内部类   *******************
    public static class Builder {
        //存储AlertDialog的各个参数, 例如title, message, icon等.
        private final AlertController.AlertParams P;
        // 属性省略

        /**
         * Constructor using a context for this builder and the {@link AlertDialog} it creates.
         */
        public Builder(Context context) {
            this(context, resolveDialogTheme(context, 0));
        }

        public Builder(Context context, int theme) {
            P = new AlertController.AlertParams(new ContextThemeWrapper(
                    context, resolveDialogTheme(context, theme)));
            mTheme = theme;
        }

        // Builder的其他代码省略 ......

        public Builder setTitle(CharSequence title) {
            P.mTitle = title;
            return this;
        }

        public Builder setMessage(CharSequence message) {
            P.mMessage = message;
            return this;
        }

        public Builder setIcon(int iconId) {
            P.mIconId = iconId;
            return this;
        }

        public Builder setPositiveButton(CharSequence text, final OnClickListener listener) {
            P.mPositiveButtonText = text;
            P.mPositiveButtonListener = listener;
            return this;
        }

        public Builder setView(View view) {
            P.mView = view;
            P.mViewSpacingSpecified = false;
            return this;
        }

        public AlertDialog create() {
            // 调用new AlertDialog构造对象， 并且将参数传递个体AlertDialog 
            final AlertDialog dialog = new AlertDialog(P.mContext, mTheme, false);
            // 5 : 将P中的参数应用的dialog中的mAlert对象中
            P.apply(dialog.mAlert);
            dialog.setCancelable(P.mCancelable);
            if (P.mCancelable) {
                dialog.setCanceledOnTouchOutside(true);
            }
            dialog.setOnCancelListener(P.mOnCancelListener);
            if (P.mOnKeyListener != null) {
                dialog.setOnKeyListener(P.mOnKeyListener);
            }
            return dialog;
        }
    }

}
```
可以看到，通过Builder来设置AlertDialog中的title, message, button等参数， 这些参数都存储在类型为AlertController.AlertParams的成员变量P中，AlertController.AlertParams中包含了与之对应的成员变量。在调用Builder类的create函数时才创建AlertDialog, 并且将Builder成员变量P中保存的参数应用到AlertDialog的mAlert对象中，即P.apply(dialog.mAlert)代码段。apply函数的实现 :
```
public void apply(AlertController dialog) {
	if (mCustomTitleView != null) {
		dialog.setCustomTitle(mCustomTitleView);
	} else {
		if (mTitle != null) {
			dialog.setTitle(mTitle);
		}
		if (mIcon != null) {
			dialog.setIcon(mIcon);
		}
		if (mIconId >= 0) {
			dialog.setIcon(mIconId);
		}
		if (mIconAttrId > 0) {
			dialog.setIcon(dialog.getIconAttributeResId(mIconAttrId));
		}
	}
	if (mMessage != null) {
		dialog.setMessage(mMessage);
	}
	if (mPositiveButtonText != null) {
		dialog.setButton(DialogInterface.BUTTON_POSITIVE, mPositiveButtonText,
				mPositiveButtonListener, null);
	}
	if (mNegativeButtonText != null) {
		dialog.setButton(DialogInterface.BUTTON_NEGATIVE, mNegativeButtonText,
				mNegativeButtonListener, null);
	}
	if (mNeutralButtonText != null) {
		dialog.setButton(DialogInterface.BUTTON_NEUTRAL, mNeutralButtonText,
				mNeutralButtonListener, null);
	}
	if (mForceInverseBackground) {
		dialog.setInverseBackgroundForced(true);
	}
	// For a list, the client can either supply an array of items or an
	// adapter or a cursor
	if ((mItems != null) || (mCursor != null) || (mAdapter != null)) {
		createListView(dialog);
	}
	if (mView != null) {
		if (mViewSpacingSpecified) {
			dialog.setView(mView, mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight,
					mViewSpacingBottom);
		} else {
			dialog.setView(mView);
		}
	}
}
```
实际上就是把P中的参数挨个的设置到AlertController中，也就是AlertDialog中的mAlert对象。在这里，Builder同时扮演了上文中提到的builder、ConcreteBuilder、Director的角色，简化了Builder模式的设计。
<br>

### 优点
* 良好的封装性，使用建造者模式可以使客户端不必知道产品内部组成的细节。
* 可以更加精细地控制产品的创建过程。将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程。
* 客户端代码的可用性和可读性得到了大大提高，易于扩展，符合“开闭原则”。

### 缺点
* 使用Builder模式会增加代码量的，产生多余的Builder对象以及Director对象。
* 对象的构建过程暴露。

<br>
### 建造者模式与工厂模式的区别
建造者模式与抽象工厂模式比较相似，二者都属于对象创建型模式。但是建造者模式返回一个完整的复杂产品，而抽象工厂模式返回一系列相关的产品；在抽象工厂模式中，客户端通过选择具体工厂来生成所需对象，而在建造者模式中，客户端通过指定具体建造者类型并指导Director类如何去生成对象，侧重于一步步构造一个复杂对象，然后将结果返回。

工厂模式一般都是创建一个产品，注重的是把这个产品创建出来就行，只要创建出来，不关心这个产品的组成部分。
建造者模式也是创建一个产品，但是不仅要把这个产品创建出来，还要关系这个产品的组成细节与组装过程。
简单来说，工厂模式关心整体，建造者模式关心细节。
<br>
### 适用场景
在以下情况下可以使用建造者模式：<br>
* 需要生成的产品对象有复杂的内部结构，这些产品对象通常包含多个成员属性。
* 需要生成的产品对象的属性相互依赖，需要指定其生成顺序。
* 隔离复杂对象的创建和使用，并使得相同的创建过程可以创建不同的产品。


### 模式扩展
建造者模式的简化:
* 省略抽象建造者角色：如果系统中只需要一个具体建造者的话，可以省略掉抽象建造者。
* 省略指挥者角色：在具体建造者只有一个的情况下，如果抽象建造者角色已经被省略掉，那么还可以省略指挥者角色，让Builder角色扮演指挥者与建造者双重角色。

<br>
### 设计模式学习资料
[java-design-patterns](https://github.com/iluwatar/java-design-patterns)<br>



