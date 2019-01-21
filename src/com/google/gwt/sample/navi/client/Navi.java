package com.google.gwt.sample.navi.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.sample.navi.client.pages.Home;
import com.google.gwt.sample.navi.client.pages.Results;
import com.google.gwt.sample.navi.client.pages.Courses;
import com.google.gwt.sample.navi.client.pages.Profile;
import com.google.gwt.sample.navi.client.pages.TimeTable;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Navi implements EntryPoint, ValueChangeHandler<String> {
	HorizontalPanel navbar = new HorizontalPanel();
	Label label = new Label();
	Home home = new Home();
	Results results = new Results();
	TimeTable timetable = new TimeTable();
	Courses courses = new Courses();
	Profile profile = new Profile();
	
	public void onModuleLoad() {
		Hyperlink homeNav = new Hyperlink("Trang chủ", "home");
		Hyperlink timetableNav = new Hyperlink("Thời khóa biểu", "timetable");
		Hyperlink coursesNav = new Hyperlink("Chương trình đào tạo", "courses");
		Hyperlink profileNav = new Hyperlink("Thông tin cá nhân", "profile");
		Hyperlink resultsNav = new Hyperlink("Kết quả học tập", "results");

		navbar.add(homeNav);
		navbar.add(timetableNav);
		navbar.add(coursesNav);
		navbar.add(profileNav);
		navbar.add(resultsNav);

		RootPanel.get("navi").add(navbar);
		RootPanel.get("app").add(home.asWidget());
		History.addValueChangeHandler(this);
		// when there is no token, the "home" token is set else changePage() is called.
		// this is useful if a user has bookmarked a site other than the homepage.
		if (History.getToken().isEmpty()) {
			History.newItem("home");
		} else {
			changePage(History.getToken());
		}
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		changePage(History.getToken());
	}

	public void changePage(String token) {
		if (token.equals("home")) {
			home.go(RootPanel.get("app"));
		} else if (token.equals("timetable")) {
			timetable.go(RootPanel.get("app"));
		} else if (token.equals("courses")) {
			courses.go(RootPanel.get("app"));
		} else if (token.equals("profile")) {
			profile.go(RootPanel.get("app"));
		} else {
			results.go(RootPanel.get("app"));
		}
	}

}
