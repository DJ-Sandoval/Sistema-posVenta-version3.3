
package Table;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;
/**
 *
 * @author Jose
 */
public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8,8));
        setForeground(new Color(48,48,48));
        setBackground(new Color(30,30,30));
    }
    
}
