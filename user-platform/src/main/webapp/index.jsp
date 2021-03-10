<head>
<jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
	<title>My Home Page</title>
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      .sing-in-btn {
        color: #235ea7;
        margin: .5em;
        border: none;
        background-color: transparent;
      }

      h2 {
        color: red;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
</head>
<body>
	<div class="container">
	    <h1 class="h3 mb-3 font-weight-normal">注册</h1>
	    <br/>
	    <h2>${error}</h2>
	    <br/>
	    <fieldset>
            <form class="form-signIn" action="login-form.jsp" method="GET">
                <span>已经拥有一个账号？</span>
                <button class="sing-in-btn"  type="submit">登录</button>
            </form>
	    </fieldset>
	    <fieldset>
            <form class="form-signin" action="register" method="POST">
                <label for="inputEmail" class="sr-only">请输出电子邮件</label>
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="请输入电子邮件" required autofocus/>
                <br/>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="请输入密码" required/>
                <br/>
                <label for="inputPhoneNumber" class="sr-only">PhoneNumber</label>
                <input type="phoneNumber" name="phoneNumber" id="inputPhoneNumber" class="form-control" placeholder="请输入手机号码" required/>
                <br/>
                <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2017-2021</p>
            </form>
		</fieldset>
	</div>
</body>