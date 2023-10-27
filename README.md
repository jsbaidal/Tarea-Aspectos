# Tarea-Aspectos
// ColorChangeAspect.aj
import java.awt.Color;
import javax.swing.JPanel;

aspect ColorChangeAspect {
    private Color currentColor = Color.WHITE;
    private JPanel panel;
    
    pointcut changeColorCall(): call(void javax.swing.AbstractButton+.doClick());

    before(): changeColorCall() {
        // Obtiene una referencia al panel
        if (panel == null) {
            panel = (JPanel) thisJoinPoint.getTarget();
        }
    }

    after(): changeColorCall() {
        // Realiza el cambio de color de fondo
        if (currentColor == Color.WHITE) {
            panel.setBackground(Color.RED);
            System.out.println("Nuevo color de fondo: Rojo");
            currentColor = Color.RED;
        } else {
            panel.setBackground(Color.WHITE);
            System.out.println("Nuevo color de fondo: Blanco");
            currentColor = Color.WHITE;
        }
    }
}

//El aspecto ColorChangeAspect se activará antes y después de que se realice un clic en cualquier botón de la ventana. Se cambiará el color de fondo entre rojo y blanco y se mostrará el nuevo color. Este aspecto se puede implementar para que esta funcionalidad que cambia el color sea independiente en el programa. En este módulo se encapsuló el comportamiento de cambiar el color de la ventana.