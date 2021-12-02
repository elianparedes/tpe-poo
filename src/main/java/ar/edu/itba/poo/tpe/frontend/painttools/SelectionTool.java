package ar.edu.itba.poo.tpe.frontend.painttools;

import ar.edu.itba.poo.tpe.frontend.ToolsListener;

public class SelectionTool implements PaintTool {
        @Override
        public void action(ToolsListener toolsListener) {
                toolsListener.onSelect();
        }
}
