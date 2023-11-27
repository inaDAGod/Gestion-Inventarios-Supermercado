package inventariosSuper.Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import inventariosSuper.Clases.Producto;
import inventariosSuper.Clases.Auditoria;
import inventariosSuper.Clases.Cliente;

public class VentanaAuditoria extends JFrame {

    private JTextArea txtADisplay;
    private JTextField txtFechaInicio;
    private JTextField txtFechaFin;

    public VentanaAuditoria() {
        getContentPane().setBackground(new Color(246, 196, 205));
        setTitle("Ventana Auditoria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        txtADisplay = new JTextArea();
        txtADisplay.setBackground(new Color(233, 225, 221));
        txtADisplay.setBounds(190, 314, 799, 250);
        getContentPane().add(txtADisplay);

        txtFechaInicio = new JTextField();
        txtFechaInicio.setBounds(164, 165, 223, 30);
        getContentPane().add(txtFechaInicio);

        txtFechaFin = new JTextField();
        txtFechaFin.setBounds(516, 165, 217, 30);
        getContentPane().add(txtFechaFin);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(863, 163, 150, 35);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarComprasEnRango();
            }
        });
        getContentPane().add(btnBuscar);

        JLabel lblFechaIni = new JLabel("Ingrese la fecha inicial");
        lblFechaIni.setBackground(new Color(163, 163, 163));
        lblFechaIni.setForeground(new Color(163, 163, 163));
        lblFechaIni.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        lblFechaIni.setBounds(164, 119, 239, 35);
        getContentPane().add(lblFechaIni);

        JLabel lblFechaFin = new JLabel("Ingrese la fecha final");
        lblFechaFin.setForeground(new Color(163, 163, 163));
        lblFechaFin.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        lblFechaFin.setBounds(514, 119, 239, 35);
        getContentPane().add(lblFechaFin);

        JLabel lblAuditoria = new JLabel("AUDITORIA DE COMPRAS REALIZADAS");
        lblAuditoria.setFont(new Font("Lucida Sans", Font.BOLD, 25));
        lblAuditoria.setBounds(282, 45, 541, 41);
        getContentPane().add(lblAuditoria);

        JLabel lblComprasEfectuadasEntre = new JLabel("Compras efectuadas");
        lblComprasEfectuadasEntre.setFont(new Font("Lucida Sans", Font.BOLD, 25));
        lblComprasEfectuadasEntre.setBounds(192, 262, 541, 41);
        getContentPane().add(lblComprasEfectuadasEntre);

        setVisible(true);
    }

    private void buscarComprasEnRango() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate fechaInicio = LocalDate.parse(txtFechaInicio.getText(), formatter);
            LocalDate fechaFin = LocalDate.parse(txtFechaFin.getText(), formatter).plusDays(1);

            Auditoria auditoria = new Auditoria();
            auditoria.agregarCompra(new Cliente("Cliente1", 3234364, 78754635,"Cota cota"), new Producto("Tomate", "Fruta o verdura", 2.50, 5, LocalDate.now().plusDays(5)), 2, LocalDateTime.now());

            auditoria.mostrarComprasEnRango(fechaInicio.atStartOfDay(), fechaFin.atStartOfDay(), txtADisplay);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese fechas en formato yyyy-MM-dd", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaAuditoria();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

