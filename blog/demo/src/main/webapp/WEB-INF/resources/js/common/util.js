/**
 * 工具方法
 */

alertify.defaults = {
    // dialogs defaults
    autoReset: true,
    basic: false,
    closable: true,
    // 非按钮点击不关闭对话框
    closableByDimmer: false,
    frameless: false,
    maintainFocus: false, // <== global default not per instance, applies to all dialogs
    maximizable: true,
    modal: true,
    movable: true,
    moveBounded: true,
    overflow: true,
    padding: true,
    pinnable: true,
    pinned: true,
    preventBodyShift: true, // <== global default not per instance, applies to all dialogs
    resizable: true,
    startMaximized: false,
    transition: 'fade',

    // notifier defaults
    notifier: {
        // auto-dismiss wait time (in seconds)
        delay: 5,
        // default position
        position: 'bottom-right',
        // adds a close button to notifier messages
        closeButton: false
    },

    // language resources
    glossary: {
        // dialogs default title
        title: '&nbsp;&nbsp;&nbsp;&nbsp;',
        // ok button text
        ok: '确定',
        // cancel button text
        cancel: '取消'
    },

    // theme settings
    theme: {
        // class name attached to prompt dialog input textbox.
        input: 'form-control',
        // class name attached to ok button
        ok: 'btn btn-outline-primary',
        // class name attached to cancel button
        cancel: 'btn btn-outline-danger'
    }
}

var dialog = {
    closeByBlank: false,
    notify(opt) {
        alertify.success(opt.msg)
    },
    alert(opt) {
        if (!opt) {
            return false
        }
        alertify.alert('警告', opt.msg || '', function () {
            if (opt.okCallback) {
                opt.okCallback()
            }
        })
    },
    confirm(opt) {
        if (!opt) {
            return false
        }
        alertify.confirm(
            opt.title || '',
            opt.msg || '',
            function () {
                if (opt.okCallback) {
                    opt.okCallback()
                }
            },
            function () {
                if (opt.cancelCallback) {
                    opt.cancelCallback()
                }
            }
        )
    },
    dialog(opt) {
        var _this = this
        if (!alertify.myDialog) {
            //define a new dialog
            alertify.dialog('myDialog', function factory() {
                return this.factory(opt)
            })
        }
    },
    factory(opt) {
        return {
            // The dialog startup function
            // This will be called each time the dialog is invoked
            // For example: alertify.myDialog( data );
            main: function (params) {
                // manipulate parameters and set options
                this.setting('myProp', data)
            },
            // The dialog setup function
            // This should return the dialog setup object ( buttons, focus and options overrides ).
            setup: function () {
                return {
                    /* buttons collection */
                    buttons: opt.buttons || [],
                    /* default focus */
                    focus: {
                        /* the element to receive default focus, has differnt meaning based on value type:
                                     number:     action button index.
                                     string:     querySelector to select from dialog body contents.
                                     function:   when invoked, should return the focus element.
                                     DOMElement: the focus element.
                                     object:     an object that implements .focus() and .select() functions.
                                 */
                        element: 0,
                        /* indicates if the element should be selected on focus or not*/
                        select: false
                    },
                    /* dialog options, these override the defaults */
                    options: {
                        title: '',
                        modal: true,
                        basic: false,
                        frameless: true,
                        pinned: true,
                        movable: true,
                        moveBounded: true,
                        resizable: true,
                        autoReset: true,
                        closable: true,
                        closableByDimmer: true,
                        maximizable: true,
                        startMaximized: false,
                        pinnable: true,
                        transition: 'fade',
                        padding: true,
                        overflow: true,
                        onshow() {
                        },
                        onclose() {
                        },
                        onfocus() {
                        },
                        onmove() {
                        },
                        onmoved() {
                        },
                        onresize() {
                        },
                        onresized() {
                        },
                        onmaximize() {
                        },
                        onmaximized() {
                        },
                        onrestore() {
                        },
                        onrestored() {
                        }
                    }
                }
            },
            // This will be called once the dialog DOM has been created, just before its added to the document.
            // Its invoked only once.
            build: function () {
                // Do custom DOM manipulation here, accessible via this.elements
                // this.elements.root           ==> Root div
                // this.elements.dimmer         ==> Modal dimmer div
                // this.elements.modal          ==> Modal div (dialog wrapper)
                // this.elements.dialog         ==> Dialog div
                // this.elements.reset          ==> Array containing the tab reset anchor links
                // this.elements.reset[0]       ==> First reset element (button).
                // this.elements.reset[1]       ==> Second reset element (button).
                // this.elements.header         ==> Dialog header div
                // this.elements.body           ==> Dialog body div
                // this.elements.content        ==> Dialog body content div
                // this.elements.footer         ==> Dialog footer div
                // this.elements.resizeHandle   ==> Dialog resize handle div
                // Dialog commands (Pin/Maximize/Close)
                // this.elements.commands           ==> Object containing  dialog command buttons references
                // this.elements.commands.container ==> Root commands div
                // this.elements.commands.pin       ==> Pin command button
                // this.elements.commands.maximize  ==> Maximize command button
                // this.elements.commands.close     ==> Close command button
                // Dialog action buttons (Ok, cancel ... etc)
                // this.elements.buttons                ==>  Object containing  dialog action buttons references
                // this.elements.buttons.primary        ==>  Primary buttons div
                // this.elements.buttons.auxiliary      ==>  Auxiliary buttons div
                // Each created button will be saved with the button definition inside buttons collection
                // this.__internal.buttons[x].element
            },
            // This will be called each time the dialog is shown
            prepare: function () {
                // Do stuff that should be done every time the dialog is shown.
            },
            // This will be called each time an action button is clicked.
            callback: function (closeEvent) {
                //The closeEvent has the following properties
                //
                // index: The index of the button triggering the event.
                // button: The button definition object.
                // cancel: When set true, prevent the dialog from closing.
            },
            // To make use of AlertifyJS settings API, group your custom settings into a settings object.
            settings: {
                myProp: 'value'
            },
            // AlertifyJS will invoke this each time a settings value gets updated.
            settingUpdated: function (key, oldValue, newValue) {
                // Use this to respond to specific setting updates.
                switch (key) {
                    case 'myProp':
                        // Do something when 'myProp' changes
                        break
                }
            },
            // listen to internal dialog events.
            hooks: {
                // triggered when the dialog is shown, this is seperate from user defined onshow
                onshow: function () {
                },
                // triggered when the dialog is closed, this is seperate from user defined onclose
                onclose: function () {
                },
                // triggered when a dialog option gets updated.
                // IMPORTANT: This will not be triggered for dialog custom settings updates ( use settingUpdated instead).
                onupdate: function () {
                }
            }
        }
    }
};

var util = {
    loading: {
        show: function () {
            var loading = '<div id="loading" class="alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade"><div class="ajs-dimmer"><div class="loader loader-1" style="position: fixed;left: 45%;top: 35%;"><div class="loader-outter"></div><div class="loader-inner"></div></div></div></div>';
            $("body").append(loading);
        },
        close: function () {
            $("#loading").remove();
        }
    },
    ajax: function (opt) {
        if (!opt) {
            return false;
        }
        var _this = this;
        $.ajax({
            type: opt.type || "POST",
            url: opt.url,
            timeout: 10000,
            async: opt.async || true,
            beforeSend: function (XHR) {
                _this.loading.show();
            },
            cache: false,
            complete: function (XHR, TS) {

            },
            contentType: 'application/json',
            data: opt.data || {},
            success: function (data) {
                _this.loading.close();
                if (opt.success) {
                    opt.success(data);
                }
            },
            error: function (data) {
                _this.loading.close();
                if (opt.error) {
                    opt.error(data);
                }
            },

        })
    }
}


