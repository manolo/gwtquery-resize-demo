package com.google.gwt.query.client.plugins;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.GQuery.window;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;

/**
 */
public class ResizeSample implements EntryPoint {

  public void onModuleLoad() {

    $(".container").as(Resize.Resize).resize(new Function() {
      public void f() {
        GQuery t = $(this).find(".test");
        $(this).find(".info").text(t.width() + "x" + t.height());
      }
    }).trigger("resize");

    $(".add_text").click(new Function() {
      public void f() {
        $(this).parent().append(" Adding some more text, to grow the parent container!");
      }
    });

    $(window).as(Resize.Resize).resize(new Function(){
      public void f() {
        GQuery w = $(window);
        $(".info").eq(0).text(w.width() + "x" + w.height());
      }
    }).trigger("resize");
  }

 }
