package inventariosSuper;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FacturaPage extends JFrame {

	private JPanel contentPane;
	private Cliente cliente;

    public FacturaPage(Cliente cliente) {
        this.cliente = cliente;
        initialize();
    }

	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClienteSeleccionado = new JLabel("Cliente Seleccionado");
		lblClienteSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClienteSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblClienteSeleccionado.setBounds(109, 29, 216, 20);
		contentPane.add(lblClienteSeleccionado);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(59, 79, 73, 14);
		contentPane.add(lblNombre);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(59, 109, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(59, 139, 73, 14);
		contentPane.add(lblNumero);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(59, 169, 73, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblNombreCliente = new JLabel(cliente.getNombre());
		lblNombreCliente.setBounds(142, 79, 171, 14);
		contentPane.add(lblNombreCliente);
		
		JLabel lblIdCliente = new JLabel(String.valueOf(cliente.getId()));
		lblIdCliente.setBounds(142, 109, 171, 14);
		contentPane.add(lblIdCliente);
		
		JLabel lblNumeroCliente = new JLabel(String.valueOf(cliente.getNumero()));
		lblNumeroCliente.setBounds(142, 139, 171, 14);
		contentPane.add(lblNumeroCliente);
		
		JLabel lblDireccionCliente = new JLabel(cliente.getDireccion());
		lblDireccionCliente.setBounds(142, 169, 171, 14);
		contentPane.add(lblDireccionCliente);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacturaPage frame = new FacturaPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

