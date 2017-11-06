package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class RadioButtonActionListener implements ActionListener{

	Method call = null;
    Object object;

    public RadioButtonActionListener(Method m, Object value) {
        call = m;
        object = value;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //call method
            call.invoke(object, null);
        } catch (IllegalArgumentException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

}
    }
