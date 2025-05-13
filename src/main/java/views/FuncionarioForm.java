package views;

import dao.FuncionarioDAO;
import models.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FuncionarioForm extends JDialog {
    private JTextField txtNombre, txtApellido, txtTipoIdentificacion, txtIdentificacion, txtEstadoCivil, txtEdad, txtSexo, txtDireccion, txtTelefono;
    private JButton btnGuardar, btnCancelar;
    private FuncionarioDAO funcionarioDAO;
    private Funcionario funcionario;
    private MainView mainView;

    public FuncionarioForm(MainView mainView, Funcionario funcionario) {
        this.mainView = mainView;
        this.funcionario = funcionario;
        this.funcionarioDAO = new FuncionarioDAO();

        setTitle(funcionario == null ? "Crear Funcionario" : "Actualizar Funcionario");
        setSize(400, 400);
        setLayout(new GridLayout(10, 2));

        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtTipoIdentificacion = new JTextField();
        txtIdentificacion = new JTextField();
        txtEstadoCivil = new JTextField();
        txtEdad = new JTextField();
        txtSexo = new JTextField();
        txtDireccion = new JTextField();
        txtTelefono = new JTextField();

        btnGuardar = new JButton(funcionario == null ? "Crear" : "Actualizar");
        btnCancelar = new JButton("Cancelar");

        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Apellido:"));
        add(txtApellido);
        add(new JLabel("Tipo Idenficiación:"));
        add(txtTipoIdentificacion);
        add(new JLabel("Identificación:"));
        add(txtIdentificacion);
        add(new JLabel("Estado Civil:"));
        add(txtEstadoCivil);
        add(new JLabel("Edad:"));
        add(txtEdad);
        add(new JLabel("Sexo:"));
        add(txtSexo);
        add(new JLabel("Dirección:"));
        add(txtDireccion);
        add(new JLabel("Teléfono:"));
        add(txtTelefono);
        add(btnGuardar);
        add(btnCancelar);

        if (funcionario != null) {
            txtNombre.setText(funcionario.getNombres());
            txtApellido.setText(funcionario.getApellidos());
            txtTipoIdentificacion.setText(funcionario.getTipoIdentificacion());
            txtIdentificacion.setText(funcionario.getNumeroIdentificacion());
            txtEstadoCivil.setText(funcionario.getEstadoCivil());
            txtEdad.setText(String.valueOf(funcionario.getEdad()));
            txtSexo.setText(funcionario.getSexo());
            txtDireccion.setText(funcionario.getDireccion());
            txtTelefono.setText(funcionario.getTelefono());
        }

        btnGuardar.addActionListener(e -> guardarFuncionario());
        btnCancelar.addActionListener(e -> dispose());

        setLocationRelativeTo(null);
        setModal(true);
    }

    private void guardarFuncionario() {
        try {
            if (funcionario == null) {
                funcionario = new Funcionario();
            }

            funcionario.setNombres(txtNombre.getText());
            funcionario.setApellidos(txtApellido.getText());
            funcionario.setTipoIdentificacion(txtTipoIdentificacion.getText());
            funcionario.setNumeroIdentificacion(txtIdentificacion.getText());
            funcionario.setEstadoCivil(txtEstadoCivil.getText());
            funcionario.setSexo(txtSexo.getText());
            funcionario.setDireccion(txtDireccion.getText());
            funcionario.setTelefono(txtTelefono.getText());
            funcionario.setEdad(Integer.parseInt(txtEdad.getText()));
            funcionario.setFechaNacimiento(new Date());

            boolean success = (funcionario.getIdFuncionario() == 0)
                    ? funcionarioDAO.createFuncionario(funcionario)
                    : funcionarioDAO.updateFuncionario(funcionario);

            if (success) {
                JOptionPane.showMessageDialog(this, "Operación realizada con éxito.");
                mainView.cargarDatos();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el funcionario.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos: " + e.getMessage());
        }
    }
}