package inventariosSuper.Ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.LineBorder;

import inventariosSuper.Clases.Alerta;
import inventariosSuper.Clases.Producto;
import inventariosSuper.Clases.Recordatorios;

public class PanelAlertas extends JPanel {
    private Recordatorios recordatorios = new Recordatorios();
    private JPanel panelRecordatorios;

    public PanelAlertas(Recordatorios recordatorios) {
        this.recordatorios = recordatorios;

        setLayout(new BorderLayout(0, 0));

        panelRecordatorios = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panelRecordatorios);
        add(scrollPane, BorderLayout.CENTER);
        panelRecordatorios.setLayout(new GridLayout(0, 1, 0, 10));


        List<Alerta> alertasOrdenadas = recordatorios.obtenerAlertasOrdenadas();

        for (Alerta alerta : alertasOrdenadas) {
            JButton btnHecho = new JButton("HECHO");
            panelRecordatorios.add(crearPanelRecordatorio(alerta, btnHecho));

        }

        // Añadir un componente invisible al final para forzar el tamaño del JScrollPane
        panelRecordatorios.add(Box.createVerticalGlue());
    }

    private JPanel crearPanelRecordatorio(Alerta alerta, JButton btnHecho) {
        JPanel panelRecordatorio = new JPanel();
        panelRecordatorio.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelRecordatorio.setBackground(new Color(255, 228, 196));
        panelRecordatorio.setLayout(new BorderLayout(0, 0));

        JTextArea txtDetalles = new JTextArea();
        txtDetalles.setText("Producto: " + alerta.getProducto().getNombre() +
                "   " + alerta.getMensaje() +
                "\n Prioridad: " + alerta.getPrioridad() +
                "\nFecha de Vencimiento: " + alerta.getProducto().getFechaVencimiento()
                );
        txtDetalles.setEditable(false);
        panelRecordatorio.add(txtDetalles, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel();
        panelRecordatorio.add(panelBoton, BorderLayout.SOUTH);
        panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        panelBoton.add(btnHecho);

        // Modificar la acción del botón "HECHO"
        btnHecho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Eliminar la alerta del montículo
                recordatorios.eliminarAlerta(alerta);

                // Remover el panel de la alerta actual del panel principal
                panelRecordatorios.remove(panelRecordatorio);

                // Revalidar y repintar el panel principal
                revalidate();
                repaint();
            }
        });

        return panelRecordatorio;
    }
}
