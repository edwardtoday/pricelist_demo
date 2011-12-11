/*
 * MainWindow.java

 *
 * Created on Aug 7, 2009, 9:44:23 AM
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

/**
 * @author edwardtoday
 * 
 *         This is the main window.
 */
public class MainWindow extends javax.swing.JFrame {

	private static int currentPart, currentOption;

	/**
	 * Show debug messages in console
	 */
	private static final boolean DEBUG = false;

	/**
	 * A separate frame showing large image
	 */
	private static ImageFrame imgFrame;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3303532393676963905L;

	/**
	 * @return Whether to show debug messages in console
	 */
	public static final boolean isDebug() {
		return MainWindow.DEBUG;
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(final String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new MainWindow().setVisible(true);
			}
		});
	}

	/** Creates new form MainWindow */
	public MainWindow() {
		this.initVariables();
		this.initComponents();
	}

	/**
	 * @param evt
	 * 
	 *            If ALT+click on the image, show a larger window to view the
	 *            image
	 */
	private void canvasAreaMouseClicked(final java.awt.event.MouseEvent evt) {
		if (evt.isAltDown()) {
			// partPane.setVisible(!partPane.isVisible());
			// if (partAndRestPane.getDividerLocation() > 0) {
			// canvasArea.setResizeToFit(false);
			// partAndRestPane.setDividerLocation(0.0f);
			// } else {
			// canvasArea.setResizeToFit(true);
			// partAndRestPane.setDividerLocation(partAndRestPane
			// .getLastDividerLocation());
			// }
			// } else {
			try {
				MainWindow.imgFrame = new ImageFrame(this.canvasArea
						.getImgFilename());
				MainWindow.imgFrame
						.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				MainWindow.imgFrame.setVisible(true);
				MainWindow.imgFrame
						.addKeyListener(new java.awt.event.KeyAdapter() {
							@Override
							public void keyReleased(
									final java.awt.event.KeyEvent evt) {
								MainWindow.this.imgFrameKeyReleased(evt);
							}
						});
			} catch (final Exception e) {
			}
		}
	}

	/**
	 * @param currentPart
	 * @param currentOption
	 * 
	 *            Confirm the current selection of currentPart->currentOption
	 */
	private void confirmOptionSelection(final int currentPart,
			final int currentOption) {
		try {
			if (MainWindow.DEBUG) {
				System.out.println(Messages.getString("MainWindow.0")); //$NON-NLS-1$
			}
			if (this.optionArea.getSelectedValue().toString().startsWith(Messages.getString("MainWindow.1"))) { //$NON-NLS-1$
				this.instructionArea.setForeground(Color.red);
				this.instructionArea
						.setText(Messages.getString("MainWindow.2")); //$NON-NLS-1$
				return;
			}

			if ((currentPart == this.selected + 1)
					|| (this.selection[currentPart] != -1)) {
				this.selected = currentPart;
				this.selection[this.selected] = currentOption;
				if (currentPart <= this.selected) {
					for (int i = this.selected + 1; i < this.selection.length; i++) {
						this.selection[i] = -1;
					}
				}
				this.prodCode = Messages.getString("MainWindow.3"); //$NON-NLS-1$
				try {
					for (int i = 0; i <= this.selected; i++) {
						this.prodCode += model.Data.database.get(i).get(
								this.selection[i]).getCode()
								+ Messages.getString("MainWindow.4"); //$NON-NLS-1$
					}
				} catch (final Exception e) {
				}
				this.prodCodeArea.setText(this.prodCode);

				this.updateDisabler(currentPart, currentOption);
				if (MainWindow.DEBUG) {
					System.out.println(model.Data.disabler.toString());
				}

				model.Data.refreshPartList(currentPart);
				this.partArea.setListData(model.Data.partList);
				this.partArea.repaint();
				if (currentPart < 19) {
					this.partArea.setSelectedIndex(currentPart + 1);
					this.optionArea.clearSelection();
					this.optionArea.requestFocus();
				} else {
					this.instructionArea.setForeground(Color.blue);
					this.instructionArea
							.setText(Messages.getString("MainWindow.5")); //$NON-NLS-1$
				}

				final String progImgFilename = Messages.getString("MainWindow.6") + (currentPart + 1) //$NON-NLS-1$
						+ Messages.getString("MainWindow.7"); //$NON-NLS-1$
				this.progArea.SetImage(progImgFilename);
			} else
				return;
		} catch (final Exception e) {
		}
	}

	/**
	 * @param filename
	 * 
	 *            Display image with filename as URL in the canvasArea
	 */
	private void displayImage(final String filename) {
		this.canvasArea.SetImage(filename);
		if (this.canvasArea.getImgFilename() != null) {
			this.instructionArea
					.setText(Messages.getString("MainWindow.8")); //$NON-NLS-1$
		}
	}

	/**
	 * @param msg
	 * 
	 *            Display text message with content msg in the descriptionArea
	 */
	private void displayText(final String msg) {
		this.descriptionArea.setText(msg);
	}

	/**
	 * @param evt
	 * 
	 *            Press ESC to close the large image viewer
	 */
	private void imgFrameKeyReleased(final java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
			MainWindow.imgFrame.dispose();
		}
	}

	/**
	 * Initialize the main window components
	 */
	private void initComponents() {

		this.prodInfoPane = new javax.swing.JSplitPane();
		this.prodInfoArea = new javax.swing.JTextArea();
		this.partAndRestPane = new javax.swing.JSplitPane();
		this.optionAndTabPane = new javax.swing.JSplitPane();
		this.optionPane = new javax.swing.JScrollPane();
		this.optionArea = new javax.swing.JList();
		this.imgTxtPane = new javax.swing.JSplitPane();
		this.canvasArea = new ImageComponent();
		this.progArea = new ImageComponent();
		this.textPane = new javax.swing.JScrollPane();
		this.descriptionArea = new javax.swing.JTextArea();
		this.partPane = new javax.swing.JScrollPane();
		this.partArea = new javax.swing.JList();
		this.statusBar = new javax.swing.JSplitPane();
		this.prodCodeArea = new javax.swing.JLabel();
		this.instructionArea = new javax.swing.JLabel();

		this.setLocationByPlatform(true);
		this
				.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setTitle(Messages.getString("MainWindow.9")); //$NON-NLS-1$
		this.setResizable(false);

		this.prodInfoArea.setColumns(20);
		this.prodInfoArea.setEditable(false);
		this.prodInfoArea.setRows(5);
		this.prodInfoArea.setText(Messages.getString("MainWindow.10")); //$NON-NLS-1$
		this.prodInfoArea.setAutoscrolls(false);
		this.prodInfoArea.setFocusable(false);
		this.prodInfoArea.setMaximumSize(new java.awt.Dimension(203, 16));
		this.prodInfoArea.setToolTipText(Messages.getString("MainWindow.11")); //$NON-NLS-1$

		this.progArea.setResizeToFit(true);
		this.progArea.SetImage(Messages.getString("MainWindow.12")); //$NON-NLS-1$

		this.prodInfoPane.setDividerLocation(700);
		this.prodInfoPane.setLeftComponent(this.prodInfoArea);
		this.prodInfoPane.setRightComponent(this.progArea);

		// partArea.setBackground(new Color(240, 240, 240));
		this.partArea.setBorder(javax.swing.BorderFactory
				.createTitledBorder(Messages.getString("MainWindow.13"))); //$NON-NLS-1$
		this.partArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.partArea.setFont(new Font(Messages.getString("MainWindow.14"), 0, 12)); //$NON-NLS-1$
		this.partArea.setToolTipText(Messages.getString("MainWindow.15")); //$NON-NLS-1$
		this.partArea.setModel(new javax.swing.AbstractListModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -816536772226293071L;

			public Object getElementAt(final int i) {
				return this.strings[i];
			}

			public int getSize() {
				return this.strings.length;
			}

			String[] strings = model.Data.partList;
		});
		this.partArea
				.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							final javax.swing.event.ListSelectionEvent evt) {
						MainWindow.this.partAreaValueChanged(evt);
					}
				});
		this.partArea.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(final java.awt.event.KeyEvent evt) {
				MainWindow.this.partAreaKeyReleased(evt);
			}
		});
		this.partPane.setViewportView(this.partArea);

		// optionArea.setBackground(new Color(240, 240, 240));
		this.optionArea.setBorder(javax.swing.BorderFactory
				.createTitledBorder(Messages.getString("MainWindow.16"))); //$NON-NLS-1$
		this.optionArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.optionArea.setFont(new Font(Messages.getString("MainWindow.17"), 0, 11)); //$NON-NLS-1$
		this.optionArea
				.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							final javax.swing.event.ListSelectionEvent evt) {
						MainWindow.this.optionAreaValueChanged(evt);
					}
				});
		this.optionArea.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(final java.awt.event.KeyEvent evt) {
				MainWindow.this.optionAreaKeyReleased(evt);
			}
		});
		this.optionArea.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(final java.awt.event.MouseEvent evt) {
				MainWindow.this.optionAreaMouseClicked(evt);
			}
		});
		this.optionPane.setViewportView(this.optionArea);
		this.optionArea
				.setToolTipText(Messages.getString("MainWindow.18")); //$NON-NLS-1$

		this.canvasArea.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(final java.awt.event.MouseEvent evt) {
				MainWindow.this.canvasAreaMouseClicked(evt);
			}
		});
		this.canvasArea.setMaximumSize(new Dimension(Short.MAX_VALUE,
				Short.MAX_VALUE));
		this.canvasArea
				.setToolTipText(Messages.getString("MainWindow.19")); //$NON-NLS-1$

		this.descriptionArea.setColumns(20);
		this.descriptionArea.setEditable(false);
		this.descriptionArea.setRows(5);
		this.descriptionArea
				.setToolTipText(Messages.getString("MainWindow.20")); //$NON-NLS-1$
		this.textPane.setViewportView(this.descriptionArea);
		this.textPane.setMaximumSize(new Dimension(Short.MAX_VALUE,
				Short.MAX_VALUE));

		this.imgTxtPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.imgTxtPane.setDividerLocation(420);
		this.imgTxtPane.setDividerSize(1);
		this.imgTxtPane.setTopComponent(this.canvasArea);
		this.imgTxtPane.setBottomComponent(this.textPane);
		this.imgTxtPane.setMaximumSize(new Dimension(Short.MAX_VALUE,
				Short.MAX_VALUE));

		this.optionAndTabPane.setBorder(null);
		this.optionAndTabPane.setDividerLocation(250);
		this.optionAndTabPane.setDividerSize(5);
		this.optionAndTabPane.setLeftComponent(this.optionPane);
		this.optionAndTabPane.setRightComponent(this.imgTxtPane);

		this.partAndRestPane.setBorder(null);
		this.partAndRestPane.setDividerLocation(240);
		this.partAndRestPane.setDividerSize(5);
		this.partAndRestPane.setRightComponent(this.optionAndTabPane);
		this.partAndRestPane.setLeftComponent(this.partPane);

		this.prodCodeArea.setBorder(javax.swing.BorderFactory
				.createTitledBorder(Messages.getString("MainWindow.21"))); //$NON-NLS-1$
		// prodCodeArea.setBorder(null);
		this.prodCodeArea.setToolTipText(Messages.getString("MainWindow.22")); //$NON-NLS-1$
		this.instructionArea.setBorder(null);
		this.instructionArea.setText(Messages.getString("MainWindow.23")); //$NON-NLS-1$
		this.instructionArea
				.setToolTipText(Messages.getString("MainWindow.24")); //$NON-NLS-1$

		this.statusBar.setBorder(null);
		this.statusBar.setDividerLocation(450);
		this.statusBar.setDividerSize(9);
		this.statusBar.setLeftComponent(this.prodCodeArea);
		this.statusBar.setRightComponent(this.instructionArea);

		final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this
				.getContentPane());
		this.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addComponent(
						this.prodInfoPane,
						javax.swing.GroupLayout.DEFAULT_SIZE, 1011,
						Short.MAX_VALUE).addContainerGap()).addComponent(
				this.partAndRestPane, javax.swing.GroupLayout.DEFAULT_SIZE,
				1023, Short.MAX_VALUE).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(
						this.statusBar, javax.swing.GroupLayout.DEFAULT_SIZE,
						1011, Short.MAX_VALUE).addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												this.prodInfoPane,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												150,// javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												this.partAndRestPane,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												480,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												this.statusBar,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												44, Short.MAX_VALUE)
										.addContainerGap()));

		this.pack();
		this.partArea.requestFocus();
	}

	/**
	 * Initialize runtime variables
	 */
	private void initVariables() {
		model.Data.initAllVariables();

		this.selected = -1;
		this.selection = new int[20];
		for (int i = 0; i < this.selection.length; i++) {
			this.selection[i] = -1;
		}
		this.prodCode = Messages.getString("MainWindow.25"); //$NON-NLS-1$
	}

	/**
	 * @param evt
	 *            In optionArea, press LEFT to switch to partArea; press ENTER
	 *            to confirm selection
	 */
	private void optionAreaKeyReleased(final java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
			this.partArea.requestFocusInWindow();
		} else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			this.confirmOptionSelection(this.partArea.getSelectedIndex(),
					this.optionArea.getSelectedIndex());
		}
	}

	/**
	 * @param evt
	 *            In optionArea, double click to confirm selection
	 */
	private void optionAreaMouseClicked(final java.awt.event.MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			this.confirmOptionSelection(this.partArea.getSelectedIndex(),
					this.optionArea.locationToIndex(evt.getPoint()));
		}
	}

	/**
	 * @param evt
	 *            When option changes, update the image and text shown
	 */
	private void optionAreaValueChanged(
			final javax.swing.event.ListSelectionEvent evt) {
		this.instructionArea.setForeground(Color.black);
		this.instructionArea.setText(Messages.getString("MainWindow.26")); //$NON-NLS-1$
		// Decide the content in the description area by the items chosen in
		// part list and option list
		MainWindow.currentPart = this.partArea.getSelectedIndex();
		MainWindow.currentOption = this.optionArea.getSelectedIndex();
		this.refreshDisplay(MainWindow.currentPart, MainWindow.currentOption);

	}

	/**
	 * @param evt
	 *            In partAreaa, press RIGHT to switch to optionArea
	 */
	private void partAreaKeyReleased(final java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.optionArea.requestFocusInWindow();
		}
	}

	/**
	 * @param evt
	 *            When part changes, update the optionList, image and text shown
	 */
	private void partAreaValueChanged(
			final javax.swing.event.ListSelectionEvent evt) {
		this.instructionArea.setText(Messages.getString("MainWindow.27")); //$NON-NLS-1$
		MainWindow.currentPart = this.partArea.getSelectedIndex();
		if (MainWindow.currentPart < 0)
			return;
		this.refreshDisplay(MainWindow.currentPart, -1);
		if (MainWindow.DEBUG) {
			System.out.println(Messages.getString("MainWindow.28") + MainWindow.currentPart); //$NON-NLS-1$
		}

		model.Data.refreshLists();

		this.optionArea.setModel(new javax.swing.AbstractListModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2191865894954012974L;

			public Object getElementAt(final int i) {
				return this.strings[i];
			}

			public int getSize() {
				return this.strings.length;
			}

			String[] strings = model.Data.lists.get(MainWindow.currentPart);
		});
		switch (MainWindow.currentPart) {
		case 0:
			// Application; Version
			this.displayText(Messages.getString("MainWindow.29")); //$NON-NLS-1$
			break;
		case 1:
			// Pipe; Orientation
			break;
		case 2:
			// Process Connection; Orifice
			break;
		case 3:
			// Seal
			break;
		case 4:
			// Inlet Edge Orifice
			break;
		case 5:
			// Vent/Drain
			break;
		case 6:
			// Diff. Pressure Connection; Seal
			break;
		case 7:
			// 2x Condens; Chamber Mat; Volume; PN
			break;
		case 8:
			// Filling Cap Condens. Chamber
			break;
		case 9:
			// Inlet Condens. Chamber
			break;
		case 10:
			// Outlet Condens. Chamber
			break;
		case 11:
			// 2x Shut-off Valve; Gasket
			break;
		case 12:
			// Material Shut-Off Valve
			break;
		case 13:
			// Inlet Shut-Off Valve
			break;
		case 14:
			// Outlet Shut-Off Valve
			break;
		case 15:
			// Manifold Version
			break;
		case 16:
			// Gasket Manifold
			break;
		case 17:
			// Process Connection Manifold
			break;
		case 18:
			// Seal Manifold; Screws
			break;
		case 19:
			// DP-Transmitter Deltabar
			break;
		default:

		}

	}

	/**
	 * @param currentPart
	 * @param currentOption
	 *            Refresh image and text based on currentPart and currentOption
	 */
	private void refreshDisplay(final int currentPart, final int currentOption) {
		String imgFilename;
		if (currentOption == -1) {
			imgFilename = Messages.getString("MainWindow.30") + currentPart + Messages.getString("MainWindow.31"); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			imgFilename = Messages.getString("MainWindow.32") + currentPart + Messages.getString("MainWindow.33") + currentOption + Messages.getString("MainWindow.34"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		this.displayImage(imgFilename);
		switch (currentPart) {
		case 0:
			switch (currentOption) {
			case 0:
				// break;
			case 1:
				// break;
			case 2:
				// break;
			case 3:
				this.displayText(Messages.getString("MainWindow.35")); //$NON-NLS-1$
				break;
			case 4:
				this.displayText(Messages.getString("MainWindow.36")); //$NON-NLS-1$
				break;
			case 5:
				// break;
			case 6:
				// break;
			default:
				this.displayText(Messages.getString("MainWindow.37")); //$NON-NLS-1$
				break;
			}
			break;
		case 2:
			switch (currentOption) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
			case 21:
			case 22:
			case 23:
			case 24:
			case 25:
			case 26:
			case 27:
			case 28:
			case 29:
				final String temp1 = Messages.getString("MainWindow.38"); //$NON-NLS-1$
				final String temp2 = this.optionArea.getSelectedValue()
						.toString().substring(
								this.optionArea.getSelectedValue().toString()
										.indexOf(',') + 1,
								this.optionArea.getSelectedValue().toString()
										.indexOf(';'));
				final String temp3 = Messages.getString("MainWindow.39"); //$NON-NLS-1$
				final String temp4 = this.optionArea.getSelectedValue()
						.toString().substring(
								this.optionArea.getSelectedValue().toString()
										.indexOf(';') + 1);
				this.displayText(temp1 + temp2 + temp3 + temp4);
				break;
			default:

			}
			break;
		case 5:
			switch (currentOption) {
			case 1:
				this
						.displayText(Messages.getString("MainWindow.40")); //$NON-NLS-1$
				break;
			case 2:
				this
						.displayText(Messages.getString("MainWindow.41")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		default:
			try {
				this.displayText(Messages.getString("MainWindow.42") //$NON-NLS-1$
						+ model.Data.database.get(currentPart).get(
								currentOption).getName());
			} catch (final Exception e) {
			}
			break;
		}
	}

	/**
	 * @param currentPart
	 * @param currentOption
	 *            Update disabler based on currentPart and currentOption
	 */
	private void updateDisabler(final int currentPart, final int currentOption) {
		model.Data.clearDisablerFrom(currentPart);
		switch (currentPart) {
		case 0:
			switch (currentOption) {
			case 4:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.43")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.44")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.45")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.46")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.47")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.48")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.49")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.50")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.51")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.52")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.53")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.54")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "11_H");
				// model.Data.setDisabler(currentPart, "11_R");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.55")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.56")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.57")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.58")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.59")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.60")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.61")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.62")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.63")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 1:
			switch (currentOption) {
			case 5:
			case 6:
			case 7:
			case 8:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.64")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.65")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 2:
			switch (currentOption) {
			case 0:
			case 2:
			case 4:
			case 6:
			case 8:
			case 10:
			case 12:
			case 14:
			case 16:
			case 18:
			case 20:
			case 22:
			case 24:
			case 26:
			case 28:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.66")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "8_3");
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 9:
			case 11:
			case 13:
			case 15:
			case 17:
			case 19:
			case 21:
			case 23:
			case 25:
			case 27:
			case 29:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.67")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "8_3");
				break;
			default:
			}
			break;
		case 4:
			switch (currentOption) {
			case 1:
			case 2:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.68")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 6:
			switch (currentOption) {
			case 6:
			case 7:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.69")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "8_3");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.70")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.71")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.72")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "10_V");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.73")); //$NON-NLS-1$
				break;
			case 8:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.74")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.75")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "10_H");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.76")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "10_W");
				break;
			case 9:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.77")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.78")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.79")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "10_H");
				break;
			default:
			}
			break;
		case 7:
			switch (currentOption) {
			case 0:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.80")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.81")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.82")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.83")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "10_V");
				// model.Data.setDisabler(currentPart, "10_W");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.84")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.85")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "11_H");
				// model.Data.setDisabler(currentPart, "11_M");
				// model.Data.setDisabler(currentPart, "11_N");
				// model.Data.setDisabler(currentPart, "11_R");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.86")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.87")); //$NON-NLS-1$
				break;
			case 1:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.88")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.89")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "10_W");
				// model.Data.setDisabler(currentPart, "11_A");
				// model.Data.setDisabler(currentPart, "11_H");
				// model.Data.setDisabler(currentPart, "11_R");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.90")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.91")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.92")); //$NON-NLS-1$
				break;
			case 2:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.93")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.94")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "10_V");
				// model.Data.setDisabler(currentPart, "11_A");
				// model.Data.setDisabler(currentPart, "11_H");
				// model.Data.setDisabler(currentPart, "11_R");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.95")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.96")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.97")); //$NON-NLS-1$
				break;
			case 3:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.98")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.99")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.100")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.101")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "10_W");
				// model.Data.setDisabler(currentPart, "11_A");
				// model.Data.setDisabler(currentPart, "11_H");
				// model.Data.setDisabler(currentPart, "11_N");
				// model.Data.setDisabler(currentPart, "11_R");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.102")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.103")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.104")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.105")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 8:
			switch (currentOption) {
			case 0:
			case 1:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.106")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "10_H");
				// model.Data.setDisabler(currentPart, "11_A");
				// model.Data.setDisabler(currentPart, "11_H");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.107")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.108")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 9:
			switch (currentOption) {
			case 3:
			case 4:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.109")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.110")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "11_H");
				// model.Data.setDisabler(currentPart, "11_M");
				// model.Data.setDisabler(currentPart, "11_R");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.111")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 10:
			switch (currentOption) {
			case 1:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.112")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.113")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.114")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.115")); //$NON-NLS-1$
				break;
			case 3:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.116")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.117")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.118")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.119")); //$NON-NLS-1$
				break;
			case 4:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.120")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.121")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.122")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 11:
			switch (currentOption) {
			case 0:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.123")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.124")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.125")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.126")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.127")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.128")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.129")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.130")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.131")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.132")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.133")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.134")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.135")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.136")); //$NON-NLS-1$
				break;
			case 3:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.137")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.138")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.139")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.140")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.141")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.142")); //$NON-NLS-1$
				// continue
			case 1:
			case 2:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.143")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.144")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.145")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.146")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 12:
			switch (currentOption) {
			case 3:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.147")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.148")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.149")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.150")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.151")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.152")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 13:
			switch (currentOption) {
			case 1:
			case 4:
			case 5:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.153")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.154")); //$NON-NLS-1$
				break;
			case 2:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.155")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.156")); //$NON-NLS-1$
				break;
			case 3:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.157")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 14:
			switch (currentOption) {
			case 1:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.158")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "18_D");
				break;
			case 2:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.159")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "18_D");
				break;
			case 3:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.160")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "18_E");
				break;
			default:
			}
			break;
		case 15:
			switch (currentOption) {
			case 0:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.161")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.162")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.163")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "18_B");
				// model.Data.setDisabler(currentPart, "18_C");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.164")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.165")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.166")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.167")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.168")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.169")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.170")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.171")); //$NON-NLS-1$
				break;
			case 1:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.172")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.173")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.174")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "18_B");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.175")); //$NON-NLS-1$
				break;
			case 2:
			case 7:
			case 8:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.176")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.177")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.178")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "18_B");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.179")); //$NON-NLS-1$
				break;
			case 9:
			case 10:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.180")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.181")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.182")); //$NON-NLS-1$
				// model.Data.setDisabler(currentPart, "18_B");
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.183")); //$NON-NLS-1$
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.184")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 16:
			switch (currentOption) {
			case 1:
			case 2:
				model.Data.setDisabler(currentPart, Messages.getString("MainWindow.185")); //$NON-NLS-1$
				break;
			default:
			}
			break;
		case 17:
			switch (currentOption) {
			default:
			}
			break;
		case 18:
			switch (currentOption) {
			default:
			}
			break;
		case 19:
			switch (currentOption) {
			default:
			}
			break;
		default:
		}
	}

	/**
	 * Show image description
	 */
	private ImageComponent canvasArea;

	private javax.swing.JTextArea descriptionArea;
	private javax.swing.JSplitPane imgTxtPane;
	/**
	 * Show text message
	 */
	private javax.swing.JLabel instructionArea;

	private javax.swing.JSplitPane optionAndTabPane;
	/**
	 * Show option list
	 */
	private javax.swing.JList optionArea;

	private javax.swing.JScrollPane optionPane;

	private javax.swing.JSplitPane partAndRestPane;
	/**
	 * Show part list
	 */
	private javax.swing.JList partArea;
	private javax.swing.JScrollPane partPane;

	private String prodCode;
	/**
	 * Show product code
	 */
	private javax.swing.JLabel prodCodeArea;

	private javax.swing.JTextArea prodInfoArea;

	private javax.swing.JSplitPane prodInfoPane;
	/**
	 * Show current configuration progress with image
	 */
	private ImageComponent progArea;

	private int selected;
	private int[] selection;

	private javax.swing.JSplitPane statusBar;

	private javax.swing.JScrollPane textPane;
}