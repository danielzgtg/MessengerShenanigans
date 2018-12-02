package com.example.xposedhook;

import android.content.Context;
import android.util.AttributeSet;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class Hook1 implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) {
        if (!lpparam.packageName.equals("com.facebook.orca")) {
            XposedBridge.log("we are not orca!");
            return;
        }
        XposedBridge.log("we are in orca2!");

        findAndHookConstructor("android.app.Fragment", lpparam.classLoader, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) {
                XposedBridge.log("Init Fragment!!!: " + param.thisObject.getClass().getName());
            }
        });
        XposedBridge.log("Hooked Fragment Init!");
        findAndHookConstructor("android.app.Activity", lpparam.classLoader, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) {
                XposedBridge.log("Init Activity!!!: " + param.thisObject.getClass().getName());
            }
        });
        XposedBridge.log("Hooked Activity Init!");
        findAndHookConstructor("android.view.View", lpparam.classLoader,
                Context.class,
                new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) {
                XposedBridge.log("Init View1!!!: " + param.thisObject.getClass().getName());
            }
        });
        XposedBridge.log("Hooked View Init1!");
        findAndHookConstructor("android.view.View", lpparam.classLoader,
                Context.class, AttributeSet.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        XposedBridge.log("Init View2!!!: " + param.thisObject.getClass().getName());
                    }
                });
        XposedBridge.log("Hooked View Init2!");
        findAndHookConstructor("android.view.View", lpparam.classLoader,
                Context.class, AttributeSet.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        XposedBridge.log("Init View3!!!: " + param.thisObject.getClass().getName());
                    }
                });
        XposedBridge.log("Hooked View Init3!");
        findAndHookConstructor("android.view.View", lpparam.classLoader,
                Context.class, AttributeSet.class, int.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        XposedBridge.log("Init View4!!!: " + param.thisObject.getClass().getName());
                    }
                });
        XposedBridge.log("Hooked View Init4!");
        findAndHookMethod("X.DkF", lpparam.classLoader,
                "r$0", "X.DkF", int.class, boolean.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        XposedBridge.log("DkF.r$0Intercept");
                        if (((Integer) param.args[1]) == 3) {
                            XposedBridge.log("DkF.r$0Intercept");
                            param.args[1] = 99; // soccer score
                        }
                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                    }
        });
        XposedBridge.log("Hooked Dju!");
        findAndHookMethod("X.Dju", lpparam.classLoader,
                "r$0", "X.Dju", int.class, boolean.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        XposedBridge.log("Dju.r$0Intercept");
                        if (((Integer) param.args[1]) == 3) {
                            XposedBridge.log("Dju.r$0Intercept");
                            param.args[1] = 99; // basketball score
                        }
                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                    }
                });
        XposedBridge.log("Hooked Dju!");

//        findAndHookConstructor("X.DKD", lpparam.classLoader, "X.2ZU", new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) {
//            }
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                Object t = param.thisObject;
//                XposedHelpers.setIntField(t, "b", 999);
//                XposedHelpers.setBooleanField(t, "c", false);
//                XposedHelpers.setBooleanField(t, "d", true);
//                XposedHelpers.setIntField(t, "e", 3);
//                XposedHelpers.setIntField(t, "f", 999+1000);
//                XposedHelpers.setBooleanField(t, "g", false);
//                XposedBridge.log("in DKD!");
//            }
//        });
//        XposedBridge.log("hooked DKD!");
//        findAndHookMethod("com.facebook.quicksilver.nativegames.soccer.SoccerView",
//                lpparam.classLoader, "getBestScore", new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) {
//                        XposedBridge.log("in getBestScore!");
//                        param.setResult(999);
//                    }
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) {
//                    }
//                });
//        XposedBridge.log("hooked Soccer.getBestScore!");
//        findAndHookMethod("com.facebook.quicksilver.nativegames.soccer.SoccerView",
//                lpparam.classLoader, "b", new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) {
//                        XposedBridge.log("in SoccerView b!");
//                    }
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) {
//                    }
//                });
//        XposedBridge.log("hooked Soccer.b (init)!");
    }
//
//    public void do2(LoadPackageParam lpparam) {
//    }
//
//    public void do1(LoadPackageParam lpparam) {
//
//        XposedBridge.log("we are in orca1!");
//        Class clz5mX = XposedHelpers.findClass("X.5MX", lpparam.classLoader);
//        Object dark = XposedHelpers.getStaticObjectField(clz5mX, "DARK");
//        XposedHelpers.setStaticObjectField(clz5mX, "LIGHT", dark);
//        XposedBridge.log("hooked 5MX!");
//
//        Class clz5mY = XposedHelpers.findClass("X.5MY", lpparam.classLoader);
//        Object dark2 = XposedHelpers.getStaticObjectField(clz5mY, "M3_DARK");
//        XposedHelpers.setStaticObjectField(clz5mY, "M3_LIGHT", dark2);
//        XposedHelpers.setStaticObjectField(clz5mY, "M4", dark2);
//        XposedBridge.log("hooked 5MY!");
//        findAndHookConstructor("X.9KJ", lpparam.classLoader, "X.0Lv", "X.0Lj", new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) {
//            }
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                Object o = param.args[0];
//                XposedHelpers.callMethod(o, "a", 642, true);
//                XposedBridge.log("hook9KJ -- 642");
//            }
//        });
//        XposedBridge.log("hooked 9KJ!");
//        findAndHookMethod("X.0Lj", lpparam.classLoader, "a", long.class, new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) {
//                Object[] args = param.args;
//                Object arg = args[0];
//                long l = (Long) arg;
//                XposedBridge.log("hook0Lj.a1 observed " + l);
//                //param.setResult(false);
////                if (true) {
////                    return;
////                }
////                Object[] args = param.args;
////                if (args.length != 0) {
////                    Object arg = args[0];
////                    if (arg instanceof Long) {
////                        long l = (Long) arg;
////                        if (l <= 285499361598292L) {
////                            XposedBridge.log("hook0Lj.a1 avoid 285499361598292 and lower");
////                            return;
////                        }
////                        if (l == 284232345720270L) {
////                            XposedBridge.log("hook0Lj.a1 FOUND 284232345720270L");
//////                            param.setResult(true);
////                        } else {
////                            XposedBridge.log("hook0Lj.a1 other config: " + arg);
////                        }
////                    } else {
////                        XposedBridge.log("hook0Lj.a1 not long");
////                    }
////                } else {
////                    XposedBridge.log("hook0Lj.a1 not length");
////                }
////                param.setResult(true);
//            }
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) {
//                boolean b = (Boolean) param.getResult();
//                XposedBridge.log("hook0Lj.a1 normally " + b);
////                Object[] args = param.args;
////                Object arg = args[0];
////                long l = (Long) arg;
////                if (l < 283188668665646L) {
////
////                }
//                param.setResult(true);
//            }
//        });
//        XposedBridge.log("hooked X.0Lj a1!");
//        findAndHookMethod("X.0Lj", lpparam.classLoader, "a", long.class, boolean.class, new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) {
//                Object[] args = param.args;
//                if (args.length != 0) {
//                    Object arg = args[0];
//                    if (arg instanceof Long) {
//                        long l = (Long) arg;
//                        if (l == 284232345720270L) {
//                            XposedBridge.log("hook0Lj.a2 FOUND 284232345720270L");
////                            param.setResult(true);
//                        } else {
//                            XposedBridge.log("hook0Lj.a2 other config: " + arg);
//                        }
//                    } else {
//                        XposedBridge.log("hook0Lj.a2 not long");
//                    }
//                } else {
//                    XposedBridge.log("hook0Lj.a2 not length");
//                }
//                param.setResult(true);
//            }
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) {
//            }
//        });
//        XposedBridge.log("hooked X.0Lj a2!");
//        findAndHookMethod("X.0Lj", lpparam.classLoader, "b", long.class, new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) {
//                Object[] args = param.args;
//                if (args.length != 0) {
//                    Object arg = args[0];
//                    if (arg instanceof Long) {
//                        long l = (Long) arg;
//                        if (l == 284232345720270L) {
//                            XposedBridge.log("hook0Lj.b1 FOUND 284232345720270L");
////                            param.setResult(true);
//                        } else {
//                            XposedBridge.log("hook0Lj.b1 other config: " + arg);
//                        }
//                    } else {
//                        XposedBridge.log("hook0Lj.b1 not long");
//                    }
//                } else {
//                    XposedBridge.log("hook0Lj.b1 not length");
//                }
//                param.setResult(true);
//            }
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) {
//            }
//        });
//        XposedBridge.log("hooked X.0Lj b1!");
//        findAndHookMethod("X.0Lj", lpparam.classLoader, "b", long.class, boolean.class, new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) {
//                Object[] args = param.args;
//                if (args.length != 0) {
//                    Object arg = args[0];
//                    if (arg instanceof Long) {
//                        long l = (Long) arg;
//                        if (l == 284232345720270L) {
//                            XposedBridge.log("hook0Lj.b2 FOUND 284232345720270L");
////                            param.setResult(true);
//                        } else {
//                            XposedBridge.log("hook0Lj.b2 other config: " + arg);
//                        }
//                    } else {
//                        XposedBridge.log("hook0Lj.b2 not long");
//                    }
//                } else {
//                    XposedBridge.log("hook0Lj.b2 not length");
//                }
//                param.setResult(true);
//            }
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) {
//            }
//        });
//        XposedBridge.log("hooked X.0Lj b2!");
//        findAndHookMethod("X.EVM", lpparam.classLoader, "e", "X.EVM", new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) {
//                XposedBridge.log("hookEVM true");
//                param.setResult(true);
//            }
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) {
//            }
//        });
//        XposedBridge.log("hooked EVM!");
//        findAndHookMethod("X.EFv", lpparam.classLoader, "c", "X.EFv", new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                Field f = param.thisObject.getClass().getDeclaredField("g");
//                f.set(param.thisObject, true);
//                XposedBridge.log("hookEFv setToTrue");
//            }
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) {
//            }
//        });
//        XposedBridge.log("hooked EFv!");
//    }
}
