package com.coremedia.coredining.studio.field {
import com.coremedia.coredining.studio.config.linkPropertyField;
import com.coremedia.ui.data.Bean;
import com.coremedia.ui.data.ValueExpression;
import com.coremedia.ui.data.ValueExpressionFactory;
import com.coremedia.ui.data.beanFactory;

import ext.Container;

use namespace beanFactory;

public class LinkPropertyFieldBase extends Container {

  public function LinkPropertyFieldBase(config:linkPropertyField) {
    super(config);
    initLinkListPropertyExpression(config.bindTo, config.propertyName);
  }


  // === SYNCHRONIZATION ===

  /**
   * This initialization method synchronizes the linkList content property with the {@link #linkListPropertyExpression}
   * used as model for this component.
   *
   * @param beanValueExpression
   * @param propertyName
   */
  private function initLinkListPropertyExpression(bindTo:ValueExpression, propertyName:String) {
    // TODO: implement the synchronization between the original beanValueExpression
    var outer:ValueExpression = bindTo.extendBy("properties", propertyName);
    var inner:ValueExpression = getLinkListPropertyExpression();

    // (1) set the value of the linkListPropertyExpression...
    inner.setValue(outer.getValue());

    // (2) add a listener to synchronizes changes on original expression
    //     with the linkListPropertyExpression
    outer.addChangeListener(function():void {
      inner.setValue(outer.getValue());
    });

    // (3) add a listener to synchronizes changes on linkListPropertyExpression
    //     with the original expression
    inner.addChangeListener(function():void {
      outer.setValue(inner.getValue());
    });
  }

  // === GETTERS ===

  /**
   * This value expression holds the content of the link list property.
   * The value of this expression is an array of content beans.
   * @return a ValueExpression holding an array of content beans.
   */
  public function getLinkListPropertyExpression():ValueExpression {
    if (!linkListPropertyExpression) {
      // TODO: use the ValueExpressionFactory to create a new instance
      // for the variable linkListValueExpression. Use method getModel()
      // as context and the arbitrary string "linkListProperty" as expression.
      linkListPropertyExpression = ValueExpressionFactory.create("linkListProperty", getModel());
    }
    return linkListPropertyExpression;
  }

  public function getSelectedLinkExpression():ValueExpression {
    if (!selectedLinkExpression) {
      selectedLinkExpression = ValueExpressionFactory.createSingleItemValueExpression(getLinkListPropertyExpression());
    }
    return selectedLinkExpression;
  }


  protected function getModel():Bean {
    if (!model) {
      model = beanFactory.createLocalBean();
    }
    return model;
  }


  // === ATTRIBUTES ===

  /** this model bean is the root of all ValueExpressions, used in this base component class. **/
  private var model:Bean;
  /** evaluates to the array of content objects, stored in the link list property. **/
  private var linkListPropertyExpression:ValueExpression;

  private var selectedLinkExpression:ValueExpression;
}
}