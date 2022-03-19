package com.company;

public class VapoareMVC {
    public static void main(String[] args) {
        VapoareModel model = new VapoareModel();
        VapoareModel modelInamic = new VapoareModel();
        VapoareView view = new VapoareView(model);
        VapoareView2 view2 = new VapoareView2(model);
        new VapoareController(model,modelInamic,view,view2);
        view.setVisible(true);

    }
}
