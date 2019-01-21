package com.google.gwt.sample.navi.client.pages;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Page {
	VerticalPanel component;
	
	public Page() {
		this.component = new VerticalPanel();
	}
	
	public void go(HasWidgets container) {
		container.clear();
		container.add(this.component);
	}
	
	public Widget asWidget() {
		return this.component;
	}
}
