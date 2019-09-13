// @GENERATOR:play-routes-compiler
// @SOURCE:/home/ggattamaneni/Downloads/untitled/conf/routes
// @DATE:Fri Sep 13 14:59:47 IST 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseEarthController EarthController = new controllers.ReverseEarthController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseEarthController EarthController = new controllers.javascript.ReverseEarthController(RoutesPrefix.byNamePrefix());
  }

}
