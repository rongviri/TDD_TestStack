package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.Stack;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StackView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8592495386020865931L;
	private JPanel contentPane;
	private JTable stackJTable;
	private JTextField setSizeTxtField;
	private JTextField elmToPushTxtField;
	private JTextField poppedElmTxtField;
	private int stackCapacity = 0;
	private Stack aStack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackView frame = new StackView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StackView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 30, 606, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane stackScrollPane = new JScrollPane();
		stackScrollPane.setBounds(100, 100, 499, 291);
		contentPane.add(stackScrollPane);

		JLabel setSizeLabel = new JLabel("Set Size");
		setSizeLabel.setBounds(54, 328, 65, 21);
		contentPane.add(setSizeLabel);

		setSizeTxtField = new JTextField();
		setSizeTxtField.setBounds(193, 328, 86, 20);
		contentPane.add(setSizeTxtField);
		setSizeTxtField.setColumns(10);

		JButton createStackBtn = new JButton("Create New Stack");
		createStackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int capacity = 0;
				try {
					capacity = Integer.parseInt(setSizeTxtField.getText());
					if (capacity != 0 && capacity < 100) {
						stackCapacity = capacity;
						aStack = new Stack(stackCapacity);
						DefaultTableModel model = (DefaultTableModel) stackJTable.getModel();
						for (int i = stackCapacity; i >= 1; i--) {
							model.addRow(new Object[] { "[" + i + "]" + " " });
						}
						createStackBtn.setEnabled(false);

					}
				} catch (NumberFormatException numberFormatException) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Size");
				}

			}
		});
		createStackBtn.setBounds(352, 327, 147, 23);
		contentPane.add(createStackBtn);

		JLabel elmToPushLbl = new JLabel("Element to Push");
		elmToPushLbl.setBounds(54, 370, 129, 14);
		contentPane.add(elmToPushLbl);

		JButton pushBtn = new JButton("Push");
		pushBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String elm = elmToPushTxtField.getText();
				if (aStack.isfull()) {
					pushBtn.setEnabled(false);
					elmToPushTxtField.setText("");
					JOptionPane.showMessageDialog(null, "Stack is full, we cannot add new element.");
				} else {
					try {
						aStack.push(elm);
						refresh();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		pushBtn.setBounds(352, 361, 147, 23);
		contentPane.add(pushBtn);

		elmToPushTxtField = new JTextField();
		elmToPushTxtField.setBounds(193, 359, 86, 20);
		contentPane.add(elmToPushTxtField);
		elmToPushTxtField.setColumns(10);

		JLabel popElmLbl = new JLabel("Popped Element ");
		popElmLbl.setBounds(53, 400, 130, 14);
		contentPane.add(popElmLbl);

		poppedElmTxtField = new JTextField();
		poppedElmTxtField.setEditable(false);
		poppedElmTxtField.setColumns(10);
		poppedElmTxtField.setBounds(193, 397, 86, 20);
		contentPane.add(poppedElmTxtField);

		JButton popBtn = new JButton("Pop");
		popBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aStack.isempty()) {
					popBtn.setEnabled(false);
					poppedElmTxtField.setText("");
					JOptionPane.showMessageDialog(null, "Stack is empty, we cannot pop an element.");
				} else {
					Object elm = aStack.pop();
					poppedElmTxtField.setText(elm.toString());
					refresh();
				}

			}
		});
		popBtn.setBounds(352, 395, 147, 23);
		contentPane.add(popBtn);

		stackScrollPane.setBounds(100, 30, 424, 291);
		contentPane.add(stackScrollPane);

		stackJTable = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(new String[] { "Stack Element" }, 0);
		stackJTable.setModel(dataModel);
		stackScrollPane.setViewportView(stackJTable);
	}

	private void refresh() {
		Object[] stackElements = aStack.getElements();
		AbstractTableModel tableModel = (AbstractTableModel) stackJTable.getModel();

		// all the remaining spaces in the stack from the order of counter to
		// the size, display as an empty place.
		for (int i = aStack.getSize(); i > aStack.getCounter(); i--) {
			tableModel.setValueAt("[" + i + "]", (aStack.getSize() - i), 0);
			tableModel.fireTableCellUpdated(aStack.getSize() - i, 0); // Repaint
																		// one
																		// cell.
		}

		// get the number of elements in the stack and show all the elements.
		for (int i = aStack.getCounter(); i > 0; i--) {
			tableModel.setValueAt("[" + i + "]                                                               "
					+ stackElements[i - 1].toString(), (aStack.getSize() - i), 0);
			tableModel.fireTableCellUpdated(aStack.getSize() - i, 0); // Repaint
																		// one
																		// cell.
		}
	}

}
