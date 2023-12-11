package inventariosSuper.Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import inventariosSuper.Clases.*;

public class RecordatoriosVentana extends JFrame {
    private Recordatorios recordatorios;
    private Inventario inventario;
    private Auditoria auditoria;

    private java.util.List<Cliente> listaClientes;
    private Producto produ;
    private java.util.List<Compras> listaCompras = new ArrayList<>();
    private List<Comprado> historialCompras = new ArrayList<>();

    public RecordatoriosVentana(Recordatorios r,Auditoria auditoria,Inventario inventario, List<Cliente> listaClientes,List<Comprado> historialCompras) {
        this.recordatorios = r;
        this.auditoria = auditoria;
        this.inventario = inventario;
        this.listaClientes = listaClientes;
        this.historialCompras = historialCompras;
        this.listaCompras = listaCompras;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem = new JMenuItem("< Volver");

        menuBar.add(mntmNewMenuItem);
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                VentanaInicio ventanaInicio = new VentanaInicio(inventario, auditoria, listaClientes, historialCompras);
                ventanaInicio.setVisible(true);
            }
        });

        // Crear una instancia de PanelAlertas y agregarla al contenido
        PanelAlertas panelAlertas = new PanelAlertas(recordatorios);
        getContentPane().add(panelAlertas, BorderLayout.CENTER);

        // Crear y agregar el panel de la cabecera
        JPanel panelCabecera = new JPanel();
        panelCabecera.setBackground(new Color(246, 196, 205));
        panelCabecera.setPreferredSize(new Dimension(1800, 130));
        getContentPane().add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(null);

        JLabel lblTitulo = new JLabel("RECORDATORIOS");
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(258, 48, 636, 50);
        panelCabecera.add(lblTitulo);
    }


}