
import static java.lang.Thread.sleep;


/**
 *
 * @author Divyansh
 */
public class StopWatch extends javax.swing.JFrame {

    /**
     * Creates new form Stop_watch
     */
    static int miliseconds = 0;
    static int seconds = 0;
    static int minutes = 0;
    static int hours = 0;
    static boolean state = true;

    public StopWatch() {
        initComponents();
    }

    /**
      This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        minute = new javax.swing.JLabel();
        second = new javax.swing.JLabel();
        milisecond = new javax.swing.JLabel();
        hour = new javax.swing.JLabel();
        stop = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        start = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        minute.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        minute.setText("00 :");

        second.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        second.setText("00 :");

        milisecond.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        milisecond.setText("000");

        hour.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        hour.setText("00 :");

        stop.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        start.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(second, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(milisecond, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(second, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(milisecond, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start)
                    .addComponent(stop)
                    .addComponent(reset))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void startActionPerformed(java.awt.event.ActionEvent evt) {                                      
        state = true;
        Thread t = new Thread() {
            public void run() {

                for (;;) {
                    if (state == true) {
                        try {
                            sleep(1);
                            if (miliseconds > 1000) {
                                miliseconds = 0;
                                seconds++;
                            }
                            if (seconds > 60) {
                                miliseconds = 0;
                                seconds = 0;
                                minutes++;
                            }
                            if (minutes > 60) {
                                miliseconds = 0;
                                seconds = 0;
                                minutes = 0;
                                hours++;
                            }if (miliseconds<10) {
                            milisecond.setText("00" + miliseconds);
                            }else if (miliseconds<100) {
                              milisecond.setText("0" + miliseconds);   
                            } else {
                                milisecond.setText("" + miliseconds);
                            }
                            miliseconds++;
                            if (seconds<10) {
                                second.setText("0" + seconds+" : ");
                            }
                            else {
                                second.setText(seconds+" : ");
                            }
                            if (minutes<10) {
                                minute.setText("0" + minutes+" : ");
                            }
                            else {
                                minute.setText(minutes+" : ");
                            }
                            if (hours<10){
                            hour.setText("0" + hours+" : ");
                            } else {
                            hour.setText(hours+" : ");  
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        break;
                    }
                }
            }
        };
        t.start();
    }                                     

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {                                     
        state = false;
    }                                    

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {                                      
        state = false;
        miliseconds = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        milisecond.setText("000");
        second.setText("00 : ");
        minute.setText("00 : ");
        hour.setText("00 : ");

    }                                     


    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StopWatch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel hour;
    private javax.swing.JLabel milisecond;
    private javax.swing.JLabel minute;
    private javax.swing.JButton reset;
    private javax.swing.JLabel second;
    private javax.swing.JButton start;
    private javax.swing.JButton stop;
    // End of variables declaration                   
}
