/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.ArbolBinario;
import Clases.Archivos;
import Clases.Multilistas;
import Clases.Nodo;
import Clases.NodoArbol;
import Clases.Propiedades;
import Clases.TablasHash;
import static Vistas.VtnGrupo.arr;
import static Vistas.VtnGrupo.r;
import cjb.ci.Mensaje;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author zgame
 */
public class VtnContacto extends javax.swing.JFrame {

    public static String d; // DATO A BUSCAR
    public static Nodo r1; //RAIZ DE LA MULTILISTA
    boolean validaBE = true;///////////////////cambios

    /**
     * Creates new form VtnContacto
     */
    public void transparenciaBotones() {
        jBRegresarC.setContentAreaFilled(false);
        jBAgregarC.setContentAreaFilled(false);
        jBEliminarC.setContentAreaFilled(false);
        jBMoverC.setContentAreaFilled(false);
        jBAsistente.setContentAreaFilled(false);

    }

    public boolean valida(String s) {
        boolean valida = false;

        if (s.length() == 0) {
            Mensaje.error(this, "El campo se encuentra vacio, debe ingresar un nombre primero");
            valida = false;
        } else {////////////////////////////////////////////////////////////prueba para evitar los mensajes de caracter no permitido en bus y elim
            if (s.length() > 30) {
                Mensaje.error(this, "El nombre que desea ingresar excede el numero de caracteres permitidos(30)");
                valida = false;
            } else 
            {
                for (int i = 0; i < s.length(); i++) //analiza cada caracter de la cadena de manera individual
                {
                    char caracter = s.charAt(i);
                    int valorASCII = (int) caracter;

                    //condicion que solo acepta letras
                    if (valorASCII > 64 && valorASCII < 91 || valorASCII > 96 && valorASCII < 123 || valorASCII==164 || valorASCII==165) {
                        valida = true;
                    } else {
                        valida = false;
                    }
                }
                if (valida == true) 
                {
                    //s=s.trim();
                    return valida = true;
                } else {
                    valida = false;
                    Mensaje.error(this, "El nombre que ingresó contiene caracteres no permitidos\n"
                            + "En esta sección sólo se permiten letras mayusculas/minusculas");
                    Mensaje.error(this, "CUIDADO: El espacio al final de un nombre puede ser tomado como un caracter especial");
                }
            }//fin del valida=30
        }//fin del valida s=0

        System.out.println("//////////////EL VALOR DE VALIDA ES " + valida);
        return valida;
    }

    public boolean validaBE(String s) {
        boolean validabe = false;

        if (s.length() == 0) {
            Mensaje.error(this, "El campo se ecnuentra vacio, debe ingresar un nombre primero");
            validabe = false;
        } else {////////////////////////////////////////////////////////////prueba para evitar los mensajes de caracter no permitido en bus y elim
            if (s.length() > 30) {
                Mensaje.error(this, "El nombre que desea ingresar excede el numero de caracteres permitidos(30)");
                validabe = false;
            } else {
                validabe = true;
            }//fin del valida=30
        }//fin del valida s=0

        System.out.println("//////////////EL VALOR DE VALIDA ES " + validabe);
        return validabe;
    }

    public static boolean validaC(Nodo r, String etq)//valida que el nombre de un grupo no se repita 
    {
        boolean aux = false;
        while (r != null) {
            if (r.getEtq().equalsIgnoreCase(etq.trim())) {
                aux = true;
                break;
            } else {
                r = r.getSig();
            }
        }
        System.out.println("EL DATO QUE ENCONTRE FUE:" + aux);
        return aux;
    }

    public boolean validaE(String s)//valida que no haya espacios al principio y al final de la palabra
    {
        boolean validaE=false;
        
        char c=s.charAt(0);
        String p1=Character.toString(c);
        
        if (Character.isLetter(c)==false) 
        {
            Mensaje.error(this,"Caracter invalido detectado\nSolo se permiten letras");
            Mensaje.error(this,"Recuerde que no se permite el espacio al principio ni al final de una palabra");
            validaE=false;
        }
        else
        {
            validaE=true;
        }
        
        return validaE;
    }
    
    
    public VtnContacto() {
        initComponents();
        this.setLocationRelativeTo(null); //CENTRA LA PANTALLA

        jLContactos.setForeground(Color.WHITE); //PONE EL COLOR DE LA ETIQUETA EN BLANCO
        JPContactos.setBackground(Color.WHITE);//PONE BLANCO EL COLOR DEL PANEL
        


        JPContactos.setLayout(new BoxLayout(JPContactos, BoxLayout.PAGE_AXIS));//CAMBIA EL ESTILO DE EL PANEL, PERMITE QUE LOS BOTONES NO OCUPEN TODA LA PANTALLA

        transparenciaBotones();

        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLContactos = new javax.swing.JLabel();
        jBAgregarC = new javax.swing.JButton();
        jBEliminarC = new javax.swing.JButton();
        jBRegresarC = new javax.swing.JButton();
        jBMoverC = new javax.swing.JButton();
        jLEliminarC = new javax.swing.JLabel();
        jLMoverC = new javax.swing.JLabel();
        jLAgregarC = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JPContactos = new javax.swing.JPanel();
        jBAsistente = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLFondoC = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLFondoC1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLContactos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLContactos.setText("Contactos");
        getContentPane().add(jLContactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jBAgregarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregarCNuevo.png"))); // NOI18N
        jBAgregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarCActionPerformed(evt);
            }
        });
        getContentPane().add(jBAgregarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 57, -1));

        jBEliminarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrarNuevo.png"))); // NOI18N
        jBEliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarCActionPerformed(evt);
            }
        });
        getContentPane().add(jBEliminarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 56, -1));

        jBRegresarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atrasNuevo.png"))); // NOI18N
        jBRegresarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresarCActionPerformed(evt);
            }
        });
        getContentPane().add(jBRegresarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 30));

        jBMoverC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/moverNuevo1.png"))); // NOI18N
        jBMoverC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMoverCActionPerformed(evt);
            }
        });
        getContentPane().add(jBMoverC, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 55, -1));

        jLEliminarC.setText("Eliminar");
        getContentPane().add(jLEliminarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, -1, -1));

        jLMoverC.setText("Mover");
        getContentPane().add(jLMoverC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, -1, -1));

        jLAgregarC.setText("Agregar");
        getContentPane().add(jLAgregarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JPContactos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPContactos.setLayout(new java.awt.GridLayout(0, 1, 0, 1));
        jScrollPane1.setViewportView(JPContactos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 290, 360));

        jBAsistente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoPregunta25.png"))); // NOI18N
        jBAsistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAsistenteActionPerformed(evt);
            }
        });
        getContentPane().add(jBAsistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 30, -1));

        jButton3.setText("Mover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, -1));

        jLFondoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondowhats.png"))); // NOI18N
        getContentPane().add(jLFondoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, 20));

        jLFondoC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondowa2.jpg"))); // NOI18N
        getContentPane().add(jLFondoC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarCActionPerformed

        //CAMBIE EL ORDEN DE LOS IF EN ESTA PARTE
        String s = "";

        s = JOptionPane.showInputDialog("Escriba el nombre del contacto que desea agregar");
        
            if (s == null) 
            {
            //Evita el NPE al salir del showInputDialog o presionar cancelar
            } else {
                if (valida(s) == false) {
                    System.out.println("error");//cambiar por un mensaje de error
                } else {
                    if (validaC(r1, s) == true) {
                        Mensaje.error(this, "El nombre que desea ingresar se encuentra repetido, por favor ingrese uno diferente");
                    } else {
                        if (validaE(s)==false) {
                            System.out.println("");
                        }else{
                            VtnGrupo c = new VtnGrupo();
                            if (c.validaN(s) == true) {
                                Mensaje.error(this, "El nombre que desea ingresar se encuentra ya en otro grupo");
                            } else {
                                //AQUI COMIENZA EL PROCESO DE ALTAS

                                //s=s.trim();

                                String s2 = s.toUpperCase().charAt(0) + s.substring(1, s.length());

                                Nodo con = new Nodo(null, s2.trim());
                                String[] etqs = new String[2];
                                etqs[0] = d;//toma el texto del boton que se eligio anteriorente
                                etqs[1] = s2;

                                NodoArbol nomNAS = new NodoArbol(s2.trim(), null, etqs);

                                VtnGrupo.r = Multilistas.inserta(VtnGrupo.r, con, 0, etqs); //inserta Multilista

                                VtnGrupo.arr.insertaTH(s, nomNAS);//inserta arbol

                                Propiedades p = new Propiedades(VtnGrupo.r, VtnGrupo.arr);

                                try {
                                    Archivos.guardar(p, this);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(VtnW.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                r1 = Multilistas.busca(VtnGrupo.r, d); //buscar en donde vas a insertar
                                r1 = r1.getAbj();//si
                                JPContactos.removeAll();

                                if (r1 != null) {
                                    Nodo aux = r1;
                                    while (aux != null) {
                                        JButton boton = new JButton(aux.getEtq());

                                        //boton.setLocation(50, 10);
                                        boton.setBackground(Color.WHITE);//PONE EL FONDO DEL BOTON EN BLANCO
                                        boton.setForeground(Color.BLACK);//PONE LAS LETRAS COLOR NEGRO
                                        boton.setFont(new Font("arial", 1, 14));//CAMBIA LA FUENTE Y EL TAMAÑO

                                        //ESTABLECE UN TAMAÑO POR DEFECTO PARA LOS BOTONES
                                        boton.setMinimumSize(new Dimension(JPContactos.getWidth(), 50));
                                        boton.setMaximumSize(new Dimension(JPContactos.getWidth(), 50));
                                        boton.setPreferredSize(new Dimension(JPContactos.getWidth(), 50));

                                        JPContactos.add(boton);
                                        boton.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                VtnHistorial h = new VtnHistorial();
                                                h.d1 = d;
                                                h.d2 = boton.getText();
                                                h.setVisible(true);
                                            }
                                        }
                                        );
                                        aux = aux.getSig();
                                    }
                                }
                                //AQUI TERMINA EL PROCESO DE ALTAS   
                            }//fin del validaN 
                        }  
                        }//fin del validaC
                }//fin del valida(s)    
            }//fin del valida de s =null
        
        
        JPContactos.revalidate();
        JPContactos.repaint();
    }//GEN-LAST:event_jBAgregarCActionPerformed

    private void jBMoverCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMoverCActionPerformed

        Nodo rm;
        String nom = ""; //nom=NOMBRE A BUSCAR
        String gpo = "";

        boolean b1 = true;
        boolean b2 = true;

        nom = JOptionPane.showInputDialog("Escriba el contacto que desea mover");
        
        /*VtnMoverContacto vmc = new VtnMoverContacto();
        vmc.setVisible(true);
                    
        String nom = vmc.no;*/
        
        
        

        if (nom == null) 
        {
            b1 = false;
            //Evita el NPE al salir del showInputDialog o presionar cancelar
        } else 
            if (validaBE(nom) != false) ///////////////////////////////////////prueba de valida
            {
                if (validaE(nom)==false) 
                {
                    System.out.println("");
                }
                else
                {
                    /*VtnMoverGrupo vmg = new VtnMoverGrupo();
                    vmg.setVisible(true);
                    
                    String gpo = vmg.gp;
                    System.out.println("GP"+vmg.gp);
                    System.out.println("GPO"+gpo);*/
                    
                    
                    gpo = JOptionPane.showInputDialog("Escriba el grupo al que desea mover este contacto");
                if (gpo != null) //Evita el NPE al salir del showInputDialog o presionar cancelar
                {
                b2 = false;
                    if (validaE(gpo)==false)//valida que no haya espacios al principio
                    {
                        System.out.println("");
                    }
                    else
                    {
                        
                        if (validaC(r, gpo) == false)//significa que no encontro nada 
                        {
                            Mensaje.error(this, "El grupo al cual desea mover el contacto no se encontro");
                        } 
                        else 
                        {

                            if (gpo.length() == 0) {
                                Mensaje.error(this, "Los campos no deben estar vacios");
                            }
                            if (b1 == false && b2 == false) {

                            } else if (nom.length() != 0 && gpo.length() != 0) {
                                rm = Multilistas.busca(VtnGrupo.r, gpo);
                                rm = rm.getAbj();

                                if (rm != null) {
                                    if (validaC(rm, nom) == true) {
                                        Mensaje.error(this, "El nombre que intentas ingresar esta repetido en grupo " + gpo);
                                    } else {
                                        String[] etqsE = new String[2];
                                        etqsE[0] = d;
                                        etqsE[1] = nom;

                                        String nom2 = nom.toUpperCase().charAt(0) + nom.substring(1, nom.length());
                                        String[] etqsI = new String[2];
                                        etqsI[0] = gpo;
                                        etqsI[1] = nom2;

                                        VtnGrupo.r = Multilistas.mover(VtnGrupo.r, 0, etqsE, etqsI);

                                        int pos = nom.toUpperCase().codePointAt(0) - 65;

                                        if (VtnGrupo.arr.getArr()[pos] != null) {

                                            ArbolBinario aba = new ArbolBinario();

                                            NodoArbol aux = aba.busca(VtnGrupo.arr.getArr()[pos].getR(), nom);

                                            if (aux != null) {

                                                aux.setPredecesores(etqsI);
                                                String muestra[] = aux.getPredecesores();

                                                System.out.println("Etqs modificada " + muestra[0]);
                                                System.out.println("Etqs modificadas " + muestra[1]);

                                                Propiedades p = new Propiedades(VtnGrupo.r, VtnGrupo.arr);
                                                try {
                                                    Archivos.guardar(p, this);
                                                } catch (FileNotFoundException ex) {
                                                    System.out.println(" No se encontro el archivo ");
                                                }
                                            }
                                        }
                                        r1 = Multilistas.busca(VtnGrupo.r, d);
                                        r1 = r1.getAbj();

                                        if (r1 != null) {
                                            Component componentes[] = JPContactos.getComponents();

                                            for (int i = 0; i < componentes.length; i++) {
                                                System.out.println(((JButton) componentes[i]).getText());
                                                if (etqsE[1].trim().equalsIgnoreCase(((JButton) componentes[i]).getText().trim())) {
                                                    JPContactos.remove(i);
                                                }
                                            }

                                        } else {
                                            JPContactos.removeAll();
                                        }

                                        JPContactos.revalidate();//NO MOVER DE AQUI
                                        JPContactos.repaint();
                                    }
                                } else {
                                    String[] etqsE = new String[2];
                                    etqsE[0] = d;
                                    etqsE[1] = nom;

                                    String nom2 = nom.toUpperCase().charAt(0) + nom.substring(1, nom.length());
                                    String[] etqsI = new String[2];
                                    etqsI[0] = gpo;
                                    etqsI[1] = nom2;
                                    VtnGrupo.r = Multilistas.mover(VtnGrupo.r, 0, etqsE, etqsI);

                                    int pos = nom.toUpperCase().codePointAt(0) - 65;

                                    if (VtnGrupo.arr.getArr()[pos] != null) {

                                        ArbolBinario aba = new ArbolBinario();

                                        NodoArbol aux = aba.busca(VtnGrupo.arr.getArr()[pos].getR(), nom);

                                        if (aux != null) {

                                            aux.setPredecesores(etqsI);

                                            String muestra[] = aux.getPredecesores();

                                            System.out.println("Etqs modificada " + muestra[0]);
                                            System.out.println("Etqs modificadas " + muestra[1]);

                                            Propiedades p = new Propiedades(VtnGrupo.r, VtnGrupo.arr);
                                            try {
                                                Archivos.guardar(p, this);
                                            } catch (FileNotFoundException ex) {
                                                System.out.println(" No se encontro el archivo ");
                                            }
                                        }
        //
                                    }
                                    r1 = Multilistas.busca(VtnGrupo.r, d);
                                    r1 = r1.getAbj();

                                    if (r1 != null) {
                                        Component componentes[] = JPContactos.getComponents();

                                        for (int i = 0; i < componentes.length; i++) {
                                            System.out.println(((JButton) componentes[i]).getText());
                                            if (etqsE[1].trim().equalsIgnoreCase(((JButton) componentes[i]).getText().trim())) {
                                                JPContactos.remove(i);
                                            }
                                        }
                                    } else {
                                        JPContactos.removeAll();
                                    }

                                    JPContactos.revalidate();//NO MOVER DE AQUI
                                    JPContactos.repaint();
                                }
                            }
                        }
                        
                        
                    }//fin del validaE de grupo
            }//fin del gpo!=null
        }/////////FIN DE VALIDA
    }//fin del validaE
            
        JPContactos.revalidate();
        JPContactos.repaint();
        System.out.println(Multilistas.desp(VtnGrupo.r, 0));
    }//GEN-LAST:event_jBMoverCActionPerformed

    private void jBEliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarCActionPerformed

        String s = "";

        s = JOptionPane.showInputDialog("Escriba el nombre del contacto que desea eliminar");

        if (s == null) {
            //Evita el NPE al salir del showInputDialog o presionar cancelar
        } else if (valida(s) == false) {
            //Mensaje.error(this, "Debe rellenar el campo");
        } else {
            String[] etqs = new String[2];
            etqs[0] = d;
            etqs[1] = s;

            boolean c = false;

            if (cjb.ci.Mensaje.pregunta(this, "Eliminar contacto\nSe eliminaran las conversaciones "
                    + "asociadas a este contacto\n¿Desea continuar?") == 0) {
                c = true;
            }
            if (c == true) {

                VtnGrupo.r = Multilistas.elimina(VtnGrupo.r, 0, etqs);

                int pos = s.toUpperCase().codePointAt(0) - 65;

                if (VtnGrupo.arr.getArr()[pos] != null) {

                    VtnGrupo.arr.elimina(s);

                    Propiedades p = new Propiedades(VtnGrupo.r, VtnGrupo.arr);

                    try {
                        Archivos.guardar(p, this);
                    } catch (FileNotFoundException ex) {
                        System.out.println("No se encontro el archivo");
                    }
                } else {
                    Mensaje.error(this, "No hay datos en esta posicion del arreglo");
                }

                //movi esto dentro del if
                r1 = Multilistas.busca(VtnGrupo.r, d);
                r1 = r1.getAbj();

                if (r1 != null) {
                    Component componentes[] = JPContactos.getComponents();

                    for (int i = 0; i < componentes.length; i++) {
                        System.out.println(((JButton) componentes[i]).getText());
                        if (etqs[1].trim().equalsIgnoreCase(((JButton) componentes[i]).getText().trim())) {
                            JPContactos.remove(i);
                        }
                    }
                } else {
                    JPContactos.removeAll();
                }
                ////////////////////////////
            }

        }
        JPContactos.updateUI();

        System.out.println(Multilistas.desp(VtnGrupo.r, 0));
    }//GEN-LAST:event_jBEliminarCActionPerformed

    private void jBRegresarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarCActionPerformed
        new VtnGrupo().setVisible(true);
        dispose();
    }//GEN-LAST:event_jBRegresarCActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        r1 = Multilistas.busca(VtnGrupo.r, d);
        r1 = r1.getAbj();
        
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setText("Grupo "+d);
        
        
        JPContactos.removeAll();

        if (r1 != null) {
            Nodo aux = r1;
            while (aux != null) {
                JButton boton = new JButton(aux.getEtq());

                boton.setBackground(Color.WHITE);//PONE EL FONDO DEL BOTON EN BLANCO
                boton.setForeground(Color.BLACK);//PONE LAS LETRAS COLOR NEGRO
                boton.setFont(new Font("arial", 1, 14));//CAMBIA LA FUENTE Y EL TAMAÑO

                //ESTABLECE UN TAMAÑO POR DEFECTO PARA LOS BOTONES
                boton.setMinimumSize(new Dimension(JPContactos.getWidth(), 50));
                boton.setMaximumSize(new Dimension(JPContactos.getWidth(), 50));
                boton.setPreferredSize(new Dimension(JPContactos.getWidth(), 50));

                JPContactos.add(boton);
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        VtnHistorial h = new VtnHistorial();
                        h.d1 = d;
                        h.d2 = boton.getText();
                        h.setVisible(true);
                        dispose();
                    }
                }
                );
                aux = aux.getSig();
            }
        }

        JPContactos.revalidate();
        JPContactos.repaint();

    }//GEN-LAST:event_formWindowOpened

    private void jBAsistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAsistenteActionPerformed
        JOptionPane.showMessageDialog(rootPane, "                                                     ¡Bienvenido a la ventana de contactos!\n"
                + "En esta ventana observaras los contactos que esten almacenados dentro del grupo que hayas ingresado\n"
                + "En esta ventana podras realizar distintas acciones como agregar o eliminar un contacto\n"
                + "Asi como buscar entre los distintos contactos que tengas y observar tu historial de chats");
    }//GEN-LAST:event_jBAsistenteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        VtnMover mv  = new VtnMover();
        mv.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(VtnContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnContacto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel JPContactos;
    private javax.swing.JButton jBAgregarC;
    private javax.swing.JButton jBAsistente;
    private javax.swing.JButton jBEliminarC;
    private javax.swing.JButton jBMoverC;
    private javax.swing.JButton jBRegresarC;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLAgregarC;
    private javax.swing.JLabel jLContactos;
    private javax.swing.JLabel jLEliminarC;
    private javax.swing.JLabel jLFondoC;
    private javax.swing.JLabel jLFondoC1;
    private javax.swing.JLabel jLMoverC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
