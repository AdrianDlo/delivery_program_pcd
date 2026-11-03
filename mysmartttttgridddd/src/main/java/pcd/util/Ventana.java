package pcd.util;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;

/**
 * Ventana de trazas.
 *
 * ATENCIÓN:
 *  - Esta clase NO es thread-safe a propósito.
 *  - Si varios threads escriben a la vez, pueden aparecer problemas.
 */

public class Ventana {

    // Colores típicos de trazas
    public static final Color NEGRO = Color.BLACK;
    public static final Color ROJO  = new Color(180, 0, 0);
    public static final Color AZUL  = new Color(0, 60, 180);
    public static final Color VERDE = new Color(0, 140, 0);
    public static final Color GRIS  = Color.DARK_GRAY;

    private final JFrame frame;
    private final JTextPane pane;
    private final StyledDocument doc;

    public Ventana(int x, int y, int ancho, int alto, String titulo) {
        frame = new JFrame(titulo);
        frame.setBounds(x, y, ancho, alto);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(titulo);
        pane = new JTextPane();
        pane.setEditable(false);
        pane.setFont(new Font("Monospaced", Font.PLAIN, 13));
        pane.setBorder(new EmptyBorder(8, 8, 8, 8));

        doc = pane.getStyledDocument();

        JScrollPane scroll = new JScrollPane(pane);
        frame.setContentPane(scroll);

        frame.setVisible(true);
    }

    /**
     * Escribe una línea de texto en el color indicado.
     * Cada línea conserva su color.
     */
    public void traza(String texto, Color color) {
        Style style = pane.addStyle("estilo", null);
        StyleConstants.setForeground(style, color);

        try {
            doc.insertString(doc.getLength(),
                    texto + System.lineSeparator(),
                    style);
            pane.setCaretPosition(doc.getLength());
        } catch (BadLocationException e) {
            // No debería ocurrir en uso normal
            e.printStackTrace();
        }
    }

    /**
     * Atajo: traza en negro.
     */
    public void traza(String texto) {
        traza(texto, NEGRO);
    }

    /**
     * Limpia la ventana.
     */
    public void limpiar() {
        pane.setText("");
    }

    /**
     * Cambia el título de la ventana.
     */
    public void setTitulo(String titulo) {
        frame.setTitle(titulo);
    }

    /**
     * Cierra la ventana.
     */
    public void cerrar() {
        frame.dispose();
    }
}
