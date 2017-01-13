package com.coremedia.coredining.studio.plugins {
import com.coremedia.coredining.studio.config.disableWhenEmptyPlugin;
import com.coremedia.ui.data.ValueExpression;

import ext.Button;
import ext.Component;
import ext.Plugin;

public class DisableWhenEmptyPluginBase implements Plugin {
  public function DisableWhenEmptyPluginBase(config:disableWhenEmptyPlugin = null) {
    listValueExpression = config.listValueExpression;
  }

  private var listValueExpression:ValueExpression;

  public function init(component:Component):void {
    var btn:Button = component as Button;
    if (btn) {
      var toggleButton:Function = function () {
        var value:Array = listValueExpression.getValue() as Array;
        if (value && value.length > 0) {
          btn.enable();
        } else {
          btn.disable();
        }
      };


    }

    listValueExpression.addChangeListener(toggleButton);
    toggleButton();
  }
}
}