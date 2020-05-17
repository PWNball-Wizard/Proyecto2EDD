/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.Multilistas;
import Clases.Nodo;
import cjb.ci.Mensaje;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author zgame
 */
public class VtnHistorial extends javax.swing.JFrame {

    public String d1;
    public String d2;
    public Nodo r2;

    /**
     * Creates new form MnuHistorial
     */
    public VtnHistorial() {
        initComponents();
        this.setLocationRelativeTo(null);//CENTRA LA PANTALLA
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLHistorial = new javax.swing.JLabel();
        jBAgregarH = new javax.swing.JButton();
        jBEliminarH = new javax.swing.JButton();
        jLAgregarH = new javax.swing.JLabel();
        jLEliminarH = new javax.swing.JLabel();
        jBRegresarH = new javax.swing.JButton();
        JPHistorial = new javax.swing.JPanel();
        jLFondoH = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLHistorial.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLHistorial.setText("Historial de Chats");
        getContentPane().add(jLHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jBAgregarH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregarg50.jpg"))); // NOI18N
        jBAgregarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarHActionPerformed(evt);
            }
        });
        getContentPane().add(jBAgregarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 54, -1));

        jBEliminarH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/elimina50.jpg"))); // NOI18N
        jBEliminarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarHActionPerformed(evt);
            }
        });
        getContentPane().add(jBEliminarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 54, -1));

        jLAgregarH.setText("Agregar");
        getContentPane().add(jLAgregarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, -1, -1));

        jLEliminarH.setText("Eliminar");
        getContentPane().add(jLEliminarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, -1, -1));

        jBRegresarH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresa.jpg"))); // NOI18N
        jBRegresarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresarHActionPerformed(evt);
            }
        });
        getContentPane().add(jBRegresarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 58, -1));

        JPHistorial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPHistorial.setLayout(new java.awt.GridLayout(0, 1, 0, 1));
        getContentPane().add(JPHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 273, 370));

        jLFondoH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondowhats.png"))); // NOI18N
        getContentPane().add(jLFondoH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoverde.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarHActionPerformed

        boolean b = false;//BANDERA PARA VERIFICAR SI ESTA BIEN ESCRITA LA FECHA

        String s = "";
        s = JOptionPane.showInputDialog("Escriba el dia a agregar");

        String partes[] = s.split("/");

        if (Integer.parseInt(partes[0]) > 31
                || Integer.parseInt(partes[0]) < 1
                || Integer.parseInt(partes[1]) > 12
                || Integer.parseInt(partes[1]) < 1
                || Integer.parseInt(partes[2]) < 0) {
            Mensaje.error(this, "La fecha que ingresaste es incorrecta");
        } else {

            //AGREGAR AQUI METODO PARA VALIDAR LA FECHA
            if (s.length() == 0) {
                Mensaje.error(this, "Rellene el campo");
            } else {
                if (b = true) {
                    Nodo his = new Nodo(null, s);
                    String[] etqs = new String[3];
                    etqs[0] = d1;
                    etqs[1] = d2;
                    etqs[2] = s;
                    VtnGrupo.r = Multilistas.inserta(VtnGrupo.r, his, 0, etqs);

                    r2 = Multilistas.busca(VtnGrupo.r, d1);

                    r2 = r2.getAbj();
                    r2 = Multilistas.busca(r2, d2);

                    JPHistorial.removeAll();

                    r2 = r2.getAbj();
                    if (r2 != null) {
                        Nodo aux = r2;
                        while (aux != null) {
                            JButton boton = new JButton(aux.getEtq());
                            JPHistorial.add(boton);
                            boton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    vtnChat nivel3 = new vtnChat();
                                    nivel3.d1 = d1;
                                    nivel3.d2 = d2;
                                    nivel3.d3 = boton.getText();
                                    nivel3.setVisible(true);
                                }
                            }
                            );
                            aux = aux.getSig();
                        }
                    }

                    JPHistorial.revalidate();
                    JPHistorial.repaint();

                } else {
                    Mensaje.error(this, "Formato de fecha no valido");
                }
            }
        }
        System.out.println(Multilistas.desp(VtnGrupo.r, 0));
    }//GEN-LAST:event_jBAgregarHActionPerformed

    private void jBRegresarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarHActionPerformed

        VtnContacto c = new VtnContacto();
       c.setVisible(true);
        c.d = d1;
        c.r1 = Multilistas.busca(VtnGrupo.r, d1);
        dispose();
    }//GEN-LAST:event_jBRegresarHActionPerformed

    private void jBEliminarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarHActionPerformed
        boolean b = false;//BANDERA PARA VERIFICAR SI ESTA BIEN ESCRITA LA FECHA

        String s = "";
        s = JOptionPane.showInputDialog("Escriba la fecha a eliminar");

        String partes[] = s.split("/");

        if (Integer.parseInt(partes[0]) > 31
                || Integer.parseInt(partes[0]) < 1
                || Integer.parseInt(partes[1]) > 12
                || Integer.parseInt(partes[1]) < 1
                || Integer.parseInt(partes[2]) < 0) {
            Mensaje.error(this, "La fecha que ingresaste es incorrecta");
        } else {

            //AGREGAR AQUI METODO PARA VALIDAR LA FECHA
            if (s.length() == 0) {
                Mensaje.error(this, "Rellene el campo");
            } else {
//                if (b = true) {
                Nodo his = new Nodo(null, s);
                System.out.println("Esto es lo que hay en la cadena de historial " + s);
                String[] etqs = new String[3];
                etqs[0] = d1;
                etqs[1] = d2;
                etqs[2] = s;
//                    VtnGrupo.r = Multilistas.inserta(VtnGrupo.r, his, 0, etqs);
                boolean c = false;

                if (cjb.ci.Mensaje.pregunta(this, "Eliminar grupo\nSe eliminaran los contactos "
                        + "y conversaciones asociados a este grupo\n¿Continuar?") == 0) {
                    c = true;
                }

                if (c) {
                    VtnGrupo.r = Multilistas.elimina(VtnGrupo.r, 0, etqs);
                }

                r2 = Multilistas.busca(VtnGrupo.r, d1);

                r2 = r2.getAbj();
                r2 = Multilistas.busca(r2, d2);

//                    JPHistorial.removeAll();
                r2 = r2.getAbj();
                if (r2 != null) {
                    Nodo aux = r2;
                    while (aux != null) {
                        JButton boton = new JButton(aux.getEtq());
                        System.out.println("El boton se llama " + boton.getText());
                        Component componentes[] = JPHistorial.getComponents();

                        for (int i = 0; i < componentes.length; i++) {
                            System.out.println(((JButton) componentes[i]).getText());
                            if (etqs[2].equals(((JButton) componentes[i]).getText().trim())) {
                                JPHistorial.remove(i);
                            }
                        }

//                            JPHistorial.add(boton);
                        boton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                vtnChat nivel3 = new vtnChat();
                                nivel3.d1 = d1;
                                nivel3.d2 = d2;
                                nivel3.d3 = boton.getText();
                                nivel3.setVisible(true);
                            }
                        }
                        );
                        aux = aux.getSig();
                    }
                }

                if (c) {
                    JPHistorial.revalidate();
                    JPHistorial.repaint();
                }

//                } else {
//                    Mensaje.error(this, "Formato de fecha no valido");
//                }
            }
            System.out.println(Multilistas.desp(VtnGrupo.r, 0));
        }
    }//GEN-LAST:event_jBEliminarHActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        r2 = Multilistas.busca(VtnGrupo.r, d1);

        r2 = r2.getAbj();
        r2 = Multilistas.busca(r2, d2);

        JPHistorial.removeAll();

        r2 = r2.getAbj();
        if (r2 != null) {
            Nodo aux = r2;
            while (aux != null) {
                JButton boton = new JButton(aux.getEtq());
                JPHistorial.add(boton);
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        vtnChat nivel3 = new vtnChat();
                        nivel3.d1 = d1;
                        nivel3.d2 = d2;
                        nivel3.d3 = boton.getText();
                        nivel3.setVisible(true);
                    }
                }
                );
                aux = aux.getSig();
            }
        }

        JPHistorial.revalidate();
        JPHistorial.repaint();
    }//GEN-LAST:event_formWindowOpened

    /*public void Actualizar()
    {
        r2 = Multilistas.busca(VtnGrupo.r, d1);
        
        r2 = r2.getAbj();
        r2 = Multilistas.busca(r2, d2);
        
        r2 = r2.getAbj();
        if (r2 != null)
        {
            Nodo aux = r2;
            while (aux != null)
            {
                JButton boton = new JButton(aux.getEtq());
                JPHistorial.add(boton);
                boton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        VtnW nivel3 = new VtnW();
                        nivel3.d1 = d1;
                        nivel3.d2 = d2;
                        nivel3.d3 = boton.getText();
                        nivel3.setVisible(true);
                    }
                }
                );
                aux = aux.getSig();
            }
        }
        JPHistorial.updateUI();
    }*/
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VtnHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnHistorial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPHistorial;
    private javax.swing.JButton jBAgregarH;
    private javax.swing.JButton jBEliminarH;
    private javax.swing.JButton jBRegresarH;
    private javax.swing.JLabel jLAgregarH;
    private javax.swing.JLabel jLEliminarH;
    private javax.swing.JLabel jLFondoH;
    private javax.swing.JLabel jLHistorial;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
