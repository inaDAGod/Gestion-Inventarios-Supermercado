package inventariosSuper.Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import inventariosSuper.Clases.Auditoria;
import inventariosSuper.Clases.Inventario;
import inventariosSuper.Clases.Recordatorios;

public class RecordatoriosVentana extends JFrame {
    private Recordatorios recordatorios;
    private Inventario inventario;
    private Auditoria auditoria;

    public RecordatoriosVentana(Inventario i, Auditoria a,Recordatorios r) {
        this.recordatorios = r;
        this.inventario = i;
        this.auditoria= a;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem = new JMenuItem("< Volver");
        mntmNewMenuItem.addActionListener(e -> setVisible(false));
        menuBar.add(mntmNewMenuItem);

        // Crear una instancia de PanelAlertas y agregarla al contenido
        PanelAlertas panelAlertas = new PanelAlertas(recordatorios);
        getContentPane().add(panelAlertas, BorderLayout.CENTER);

        // Crear y agregar el panel de la cabecera
        JPanel panelCabecera = new JPanel();
        panelCabecera.setBackground(new Color(255, 240, 245));
        panelCabecera.setPreferredSize(new Dimension(1800, 130));
        getContentPane().add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(null);

        JLabel lblTitulo = new JLabel("RECORDATORIOS");
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(258, 48, 636, 50);
        panelCabecera.add(lblTitulo);
        mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VentanaInicio ventanaInicio = new VentanaInicio(inventario,auditoria);
				ventanaInicio.setVisible(true);
			}
		});
    }

   
}
