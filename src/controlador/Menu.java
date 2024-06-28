
package controlador;
import java.awt.Font;
import event.MenuEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//import javax.swing.event.MenuEvent;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author Jose
 */
public class Menu extends javax.swing.JPanel {
    
    private MenuButton selectedMenu;
    private MenuButton unSelectedMenu;
    private Animator animator;
    private MenuEvent event;
    
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setOpaque(false);
        scroll.setViewportBorder(null);
        scroll.setBorder(null);
        scroll.getViewport().setOpaque(false);
        //scroll.setVerticalScrollBar(new ScrollBarCustom());
        panelMenu.setLayout(new MigLayout("wrap, fillx, inset 0", "[fill]"));

        TimingTarget target = new TimingTargetAdapter() {
            public void timingEvent(float fraction) {
                selectedMenu.setAnimate(fraction);
                if (unSelectedMenu != null) {
                    unSelectedMenu.setAnimate(1f - fraction);
                }
            }

        };
        animator = new Animator(300, target);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        animator.setResolution(0);
    }

    public void initMenu(MenuEvent event) {
        this.event =event;
        split("PosPrincipal");
        addMenu("1", "Inicio", 0);
        addMenu("2", "Nueva Venta", 1);
        addMenu("3", "Nueva Compra", 2);
        addMenu("4", "Productos", 3);
        addMenu("5", "Clientes", 4);
        addMenu("6", "Usuarios", 5);
        addMenu("7", "Proveedores", 6);
        addMenu("8", "Medidas", 7);
        addMenu("9", "Categorias", 8);
        split("Extras");
        addMenu("10", "Configuraciones", 9);
        addMenu("11", "Reportes", 10);
        addMenu("12","Stock de productos",11);
        addMenu("13", "Historial de ventas", 12); 
        addMenu("14", "Caja", 13);
        split("Inventario");
        addMenu("15","Inventario de compras", 14);
        space();
        addMenu("key","Cerrar cuenta", 15);
    }

    public void addMenu(String icon, String text, int index) {
        MenuButton menu = new MenuButton(index);
        setFont(menu.getFont().deriveFont(Font.PLAIN, 14));
        menu.setIcon(new ImageIcon(getClass().getResource("/com/jose/icon/" + icon + ".png")));
        menu.setText(" " + text);
         menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    if (menu != selectedMenu) {   
                        unSelectedMenu = selectedMenu;
                        selectedMenu = menu;
                        animator.start();
                        event.menuSelected(index);
                    }
                }
            }
        });
        panelMenu.add(menu);
    }
    
    private void split(String name) {
        panelMenu.add(new Split(name), " h 30");
    }
    
    private void space() {
        panelMenu.add(new JLabel(), "push");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/posIcono.png"))); // NOI18N
        jLabel1.setText("SalesFusion");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));

        scroll.setOpaque(false);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        scroll.setViewportView(panelMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
