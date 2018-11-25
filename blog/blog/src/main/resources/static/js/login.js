/**
 * 登录
 */
var loginModule = {
    urls: {
        login: '/user/login',
        redirect: "/index"
    },
    bindEvent: function () {
        var _this = this;
        $('[module-name="login"]').on('click', '[action-name="submit"]', function (event) {
            _this.login();
        })
    },
    login: function () {
        var _this = this;
        util.ajax({
            url: _this.urls.login,
            type: "GET",
            data: {
                "userName": $("#userName").val(),
                "password": $("#password").val()
            },
            success: function (data) {
                if(data.success) {
                    window.location = _this.urls.redirect;
                }else{
                    dialog.alert({
                        msg: data.message || "请求失败"
                    })
                }
            },
            error: function (data) {
                dialog.alert({
                    msg: data.message || "请求失败"
                })
            }
        })
    },
    init: function () {
        this.bindEvent();
    }
}

loginModule.init();


