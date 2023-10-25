import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;


public class stopwatch implements ActionListener {
  
  JFrame fr=new JFrame();
   JButton startB =new JButton("START");
   JButton resetB =new JButton("RESET");
   JLabel timeL=new JLabel();

   int elapsedTime=0;
   int minute=0;
   int seconds=0;
   int hours=0;
   boolean started = false;
   String seconds_string=String.format("%02d",seconds);
    String minutes_string=String.format("%02d",seconds);
     String hours_string=String.format("%02d",seconds);
     

     Timer timer=new Timer(1000,new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
              elapsedTime+=1000;
              hours=(elapsedTime/3600000);
              minute=(elapsedTime/60000)%60;
              seconds=(elapsedTime/1000)%60;
              
              seconds_string=String.format("%02d", seconds);
              minutes_string=String.format("%02d", minute);
              hours_string=String.format("%02d", hours);

              timeL.setText(hours_string+":"+minutes_string+":"+seconds_string);

        }
     });

    stopwatch(){
        timeL.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timeL.setBounds(100,100,200,100);
        timeL.setFont(new Font("verdana",Font.PLAIN,35));
        timeL.setBorder(BorderFactory.createBevelBorder(1));
        timeL.setOpaque(true);
        timeL.setHorizontalAlignment(JTextField.CENTER);
       
        startB.setBounds(100, 200, 100, 50);
        startB.setFont(new Font("Ink Free",Font.PLAIN,20));
        startB.setFocusable(false);
        startB.addActionListener(this);

        resetB.setBounds(200,200, 100, 50);
        resetB.setFont(new Font("Ink Free",Font.PLAIN,20));
        resetB.setFocusable(false);
        resetB.addActionListener(this);

       fr.add(startB);
       fr.add(resetB);
       fr.add(timeL);
       fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       fr.setSize(420,420 );
       fr.setLayout(null);
       fr.setVisible(true); 
    }
    @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==startB)
            {
                 start();
            if(started==false){
                started=true;
                startB.setText("STOP");
                start();
            }
            else{
                started=false;
                startB.setText("START");
                stop();
            }
            
            }
            if(e.getSource()==resetB){
                started=false;
                startB.setText("START");
                reset();
            }
        }
    void start(){
timer.start();
    }
    void stop(){
            timer.stop();
    }
    void reset(){

        elapsedTime=0;
seconds=0;
minute=0;
hours=0;

        timer.stop();
    }
    
}
