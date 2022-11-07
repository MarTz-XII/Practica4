/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ed.ito.*;



public class MyApp  extends JFrame {
      private JPanel panelPrincipal;
    private JButton [] numeros;
    private JButton arriba,abajo,izquierda,derecha,atras,adelante;
    private Puzzle8 puzzle8;
    private PilaEstatica<Integer> pila;
    private PilaEstatica<Integer> pila1;
    private PilaEstatica<Integer> pila2;

    public MyApp(){
       
        super("Puzzle-8");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponentes();
        puzzle8= new Puzzle8();
        pila= new PilaEstatica<Integer>();
        //pila1 = new PilaEstatica<Integer>();
        pila1= new PilaEstatica<Integer>();
        pila2= new PilaEstatica<Integer>();
        llenaTablero();
        this.pack();
    }
    // Inicializa tablero visible en pantalla con el contenido del arreglo bidimencional de la instancia de Puzzle8
    private void llenaTablero(){
        int [][] pz= puzzle8.getPuzzle();
        for(int i=0;i<numeros.length;i++)
            numeros[i].setText(""+pz[i/3][i%3]);      
    }

    // Este método deberá contener el código correspondiente
    private void arribaValida(ActionEvent e){
        if(puzzle8.arriba()){
        llenaTablero();
        try{
        pila1.push(2);
        }catch(ExcepcionDeDesbordamientoDePila e2){
        JOptionPane.showMessageDialog(null,"Ya no hay mas intentos");
        System.exit(0);
        }
        if(puzzle8.haTerminado()){
        JOptionPane.showMessageDialog(null,"Has terminado el juego " );
        }
        }
        
    }
    // Este método deberá contener el código correspondiente
    private void abajoValida(ActionEvent e){
          if(puzzle8.abajo()){
        llenaTablero();
        try{
        pila1.push(1);
        }catch(ExcepcionDeDesbordamientoDePila e1){
        JOptionPane.showMessageDialog(null,"Ya no hay mas intentos");
        System.exit(0);
        }
        if(puzzle8.haTerminado()){
        JOptionPane.showMessageDialog(null,"Ha terminado el juego " );
        }
        }
    }
    // Este método deberá contener el código correspondiente
    private void izquierdaValida(ActionEvent e){
            if(puzzle8.izquierda()){
        llenaTablero();
        try{
        pila1.push(3);
        }catch(ExcepcionDeDesbordamientoDePila e3){
        JOptionPane.showMessageDialog(null,"Ya no hay mas intentos");
        System.exit(0);
        }
        if(puzzle8.haTerminado()){
        JOptionPane.showMessageDialog(null,"Ha terminado el juego" );
        }
        }
    }
    // Este método deberá contener el código correspondiente
    private void derechaValida(ActionEvent e){
           if(puzzle8.derecha()){
        llenaTablero();
        try{
        pila.push(4);
        }catch(ExcepcionDeDesbordamientoDePila e4){
        JOptionPane.showMessageDialog(null,"Ya no hay mas intentos");
        System.exit(0);
        }
        if(puzzle8.haTerminado()){
        JOptionPane.showMessageDialog(null,"Has terminado el juego" );
        }
        }
    }
     // Este método deberá contener el código correspondiente
    private void avanza (ActionEvent e){
    int a=0;
        try{
         a=pila2.pop();
        } catch(ExcepcionDePilaVacia e1){
        JOptionPane.showMessageDialog(null,"No se puede avanzar");
        }
       switch(a){
           case 1:
               puzzle8.arriba();
               llenaTablero();
               try{
                   pila1.push(2);
               }catch(ExcepcionDeDesbordamientoDePila e2){
               JOptionPane.showMessageDialog(null,"No se puede avanzar");
               }
               break;
           case 2:
                   puzzle8.abajo();
               llenaTablero();
               try{
                   pila1.push(1);
               }catch(ExcepcionDeDesbordamientoDePila e2){
               JOptionPane.showMessageDialog(null,"No se puede avanzar");
               }
               break;
           case 3:
                   puzzle8.derecha();
               llenaTablero();
               try{
                   pila1.push(4);
               }catch(ExcepcionDeDesbordamientoDePila e2){
               JOptionPane.showMessageDialog(null,"No se puede avanzar");
               }
               break;
           case 4:
                   puzzle8.izquierda();
               llenaTablero();
               try{
                   pila1.push(3);
               }catch(ExcepcionDeDesbordamientoDePila e2){
               JOptionPane.showMessageDialog(null,"No se puede avanzar");
               }
               break;
           
       }   
    
        
    }
     // Este método deberá contener el código correspondiente
    private void retrocede(ActionEvent e){
        int a=0;
        try{
         a=pila1.pop();
        } catch(ExcepcionDePilaVacia e1){
        JOptionPane.showMessageDialog(null,"No se puede retroceder");
        }
       switch(a){
           case 1:
               puzzle8.arriba();
               llenaTablero();
               try{
                   pila2.push(2);
               }catch(ExcepcionDeDesbordamientoDePila e2){
               JOptionPane.showMessageDialog(null,"No se puede avanzar");
               }
               break;
           case 2:
                   puzzle8.abajo();
               llenaTablero();
               try{
                   pila2.push(1);
               }catch(ExcepcionDeDesbordamientoDePila e2){
               JOptionPane.showMessageDialog(null,"No se puede avanzar");
               }
               break;
           case 3:
                   puzzle8.derecha();
               llenaTablero();
               try{
                   pila2.push(4);
               }catch(ExcepcionDeDesbordamientoDePila e2){
               JOptionPane.showMessageDialog(null,"No se puede avanzar");
               }
               break;
           case 4:
                   puzzle8.izquierda();
               llenaTablero();
               try{
                   pila2.push(3);
               }catch(ExcepcionDeDesbordamientoDePila e2){
               JOptionPane.showMessageDialog(null,"No se puede avanzar");
               }
               break;
           
       }
    }

    private void initComponentes(){
        this.getContentPane().setLayout(new GridLayout(4,3));
        
        this.getContentPane().add(new JLabel(""));
        arriba= new JButton("Arriba");
        arriba.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                      arribaValida(e);
                }
        });
        this.getContentPane().add(arriba);
        this.getContentPane().add(new JLabel(""));
        izquierda= new JButton("Izquierda");
        izquierda.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                     izquierdaValida(e);
            }
        });
        this.getContentPane().add(izquierda);
        panelPrincipal= new JPanel(new GridLayout(3,3));
        numeros= new JButton[9];
        for(int i=0;i<numeros.length;i++){
            numeros[i]= new JButton(""+i);
            numeros[i].setEnabled(false);
            numeros[i].setBackground(new Color(5,122,123));
            numeros[i].setFont(new Font("Arial Bold",Font.BOLD,28));
            panelPrincipal.add(numeros[i]);
        }
        this.getContentPane().add(panelPrincipal);
        derecha= new JButton("Derecha");
        derecha.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                derechaValida(e);
            }
        });
        this.getContentPane().add(derecha);
        this.getContentPane().add(new JLabel());
        abajo= new JButton("Abajo");
        abajo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 abajoValida(e);
            }
        });
        this.getContentPane().add(abajo);
        this.getContentPane().add(new JLabel());
        atras= new JButton("Atras");
        atras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    retrocede(e);
            }
        });
        this.getContentPane().add(atras);
        this.getContentPane().add(new JLabel());
        adelante= new JButton("Adelante");
        adelante.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                     avanza(e);
            }
        });
        this.getContentPane().add(adelante);

    }
    public static void main(String [] args){
          new MyApp().setVisible(true);;
    }

}
