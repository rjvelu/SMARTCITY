/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package SystemAdmin;
//import com.teamdev.jxbrowser.browser.Browser;
//import com.teamdev.jxbrowser.engine.Engine;
//import com.teamdev.jxbrowser.engine.EngineOptions;
//import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
//import com.teamdev.jxbrowser.view.swing.BrowserView;

public class MapsPanel extends javax.swing.JPanel {

    //Browser browser;
    public MapsPanel() {
        initComponents();
    }

//     private void open_site() {
//        try{
//             EngineOptions options =
//     EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("1BNDHFSC1G4NNJSWIB7FX6CBOWWCX8MKR14WNT2DH9XV6YW9EOWTXHCOQSIKV88D6J65JS").build();
//   Engine engine = Engine.newInstance(options);
//   browser = engine.newBrowser();
//   BrowserView view = BrowserView.newInstance(browser);
//              browser.navigation().loadUrl("https://www.google.com/maps/@42.3366959,-71.0951561,16.43z");
//       MainMapsPanel.add(view);
//        }
//        catch(Exception e){
//            System.out.println(e+"");
//        }
// 
// }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        SetLocationButton = new javax.swing.JLabel();
        MainMapsPanel = new javax.swing.JPanel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-google-maps-old-100.png"))); // NOI18N

        SetLocationButton.setFont(new java.awt.Font("SimSun", 0, 36)); // NOI18N
        SetLocationButton.setText("Set Location");
        SetLocationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SetLocationButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MainMapsPanelLayout = new javax.swing.GroupLayout(MainMapsPanel);
        MainMapsPanel.setLayout(MainMapsPanelLayout);
        MainMapsPanelLayout.setHorizontalGroup(
            MainMapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MainMapsPanelLayout.setVerticalGroup(
            MainMapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(SetLocationButton)
                .addContainerGap(412, Short.MAX_VALUE))
            .addComponent(MainMapsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(SetLocationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainMapsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SetLocationButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetLocationButtonMouseClicked
//        if (browser.url()!= null) {
//            String[] split1= browser.url().split("/place/");
//            String[] split2 = split1[1].split("/@");
//            String[] placeName = split2[0].split("\\+");
//            String[] longLat = split2[1].split(",");
//            String place="";
//
//            int size = placeName.length;
//            for(int i=0;i<size;i++){
//                place+=placeName[i];
//            }
//            System.out.println(place);
//            System.out.println("long->"+longLat[0]+"lat->"+longLat[1]);
//
//        }
      
        // TODO add your handling code here:
    }//GEN-LAST:event_SetLocationButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainMapsPanel;
    private javax.swing.JLabel SetLocationButton;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
