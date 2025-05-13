package views;

import dao.FuncionarioDAO;
import models.Funcionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainView extends JFrame {
    private FuncionarioDAO funcionarioDAO;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnAdd, btnUpdate, btnDelete, btnDetails;

    public MainView() {
        funcionarioDAO = new FuncionarioDAO();
        setTitle("Gestión de Funcionarios");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"ID", "Nombre", "Apellido", "Identificación"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        btnAdd = new JButton("Crear");
        btnUpdate = new JButton("Actualizar");
        btnDelete = new JButton("Eliminar");
        btnDetails = new JButton("Ver Detalles");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnDetails);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        cargarDatos();

        btnAdd.addActionListener(e -> crearFuncionario());
        btnUpdate.addActionListener(e -> actualizarFuncionario());
        btnDelete.addActionListener(e -> eliminarFuncionario());
        btnDetails.addActionListener(e -> verDetalles());

        setVisible(true);
    }

    public void cargarDatos() {
        List<Funcionario> funcionarios = funcionarioDAO.getAllFuncionarios();
        tableModel.setRowCount(0);
        for (Funcionario f : funcionarios) {
            tableModel.addRow(new Object[]{
                    f.getIdFuncionario(),
                    f.getNombres(),
                    f.getApellidos(),
                    f.getNumeroIdentificacion()
            });
        }
    }

    private void crearFuncionario() {
        FuncionarioForm form = new FuncionarioForm(this, null);
        form.setVisible(true);
    }

    private void actualizarFuncionario() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) table.getValueAt(selectedRow, 0);
            Funcionario funcionario = funcionarioDAO.getFuncionarioById(id);
            if (funcionario != null) {
                FuncionarioForm form = new FuncionarioForm(this, funcionario);
                form.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un funcionario para actualizar.");
        }
    }

    private void eliminarFuncionario() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) table.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar este funcionario?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (funcionarioDAO.deleteFuncionario(id)) {
                    JOptionPane.showMessageDialog(this, "Funcionario eliminado correctamente.");
                    cargarDatos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el funcionario.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un funcionario para eliminar.");
        }
    }

    private void verDetalles() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) table.getValueAt(selectedRow, 0);
            Funcionario funcionario = funcionarioDAO.getFuncionarioById(id);
            if (funcionario != null) {
                JOptionPane.showMessageDialog(this, "Datos del Funcionario:\n" +
                        "Nombre: " + funcionario.getNombres() + " " + funcionario.getApellidos() + "\n" +
                        "Identificación: " + funcionario.getNumeroIdentificacion() + "\n" +
                        "Sexo: " + funcionario.getSexo() + "\n" +
                        "Fecha de Nacimiento: " + funcionario.getFechaNacimiento() + "\n" +
                        "Edad: " + funcionario.getEdad() + "\n" +
                        "Estado Civil: " + funcionario.getEstadoCivil() + "\n" +
                        "Teléfono: " + funcionario.getTelefono() + "\n" +
                        "Dirección: " + funcionario.getDireccion());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un funcionario para ver detalles.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainView::new);
    }
}