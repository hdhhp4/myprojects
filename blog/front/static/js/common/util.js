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
define(['jquery'], function(jquery) {
  var module = {}

  return module
})
