package com.google.gwt.sample.navi.client.pages;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Home {
	private VerticalPanel component;
	Label test;

	public Home() {
		this.component = new VerticalPanel();
		test = new Label("home");
		this.component.add(test);
	}

	public void go(HasWidgets container) {
		container.clear();
		container.add(this.component);
	}

	public Widget asWidget() {
		return this.component;
	}
}
