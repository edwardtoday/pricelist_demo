package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author edwardtoday
 * 
 *         This class is used to store all the static data used.
 */
public class Data {

	/**
	 * Name of each part
	 */
	public static final String[] _partListPostfix = { Messages.getString("Data.0"), //$NON-NLS-1$
			Messages.getString("Data.1"), Messages.getString("Data.2"), Messages.getString("Data.3"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			Messages.getString("Data.4"), Messages.getString("Data.5"), //$NON-NLS-1$ //$NON-NLS-2$
			Messages.getString("Data.6"), //$NON-NLS-1$
			Messages.getString("Data.7"), //$NON-NLS-1$
			Messages.getString("Data.8"), Messages.getString("Data.9"), //$NON-NLS-1$ //$NON-NLS-2$
			Messages.getString("Data.10"), Messages.getString("Data.11"), //$NON-NLS-1$ //$NON-NLS-2$
			Messages.getString("Data.12"), Messages.getString("Data.13"), //$NON-NLS-1$ //$NON-NLS-2$
			Messages.getString("Data.14"), Messages.getString("Data.15"), Messages.getString("Data.16"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			Messages.getString("Data.17"), Messages.getString("Data.18"), //$NON-NLS-1$ //$NON-NLS-2$
			Messages.getString("Data.19") }; //$NON-NLS-1$

	/**
	 * Code of each part
	 */
	public static final String[] _partListPrefix = { Messages.getString("Data.20"), Messages.getString("Data.21"), Messages.getString("Data.22"), Messages.getString("Data.23"), Messages.getString("Data.24"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			Messages.getString("Data.25"), Messages.getString("Data.26"), Messages.getString("Data.27"), Messages.getString("Data.28"), Messages.getString("Data.29"), Messages.getString("Data.30"), Messages.getString("Data.31"), Messages.getString("Data.32"), Messages.getString("Data.33"), Messages.getString("Data.34"), Messages.getString("Data.35"), Messages.getString("Data.36"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			Messages.getString("Data.37"), Messages.getString("Data.38"), Messages.getString("Data.39") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	/**
	 * A database of all the part objects created
	 */
	public static ArrayList<ArrayList<SinglePart>> database;

	/**
	 * A database storing restrictions on option selection based on previous
	 * choices
	 */
	public static ArrayList<Set<String>> disabler;

	/**
	 * A database of all option lists
	 */
	public static ArrayList<String[]> lists;

	/**
	 * List of all parts
	 */
	public static String[] partList = {
			Data._partListPrefix[0] + Data._partListPostfix[0],
			Data._partListPrefix[1] + Data._partListPostfix[1],
			Data._partListPrefix[2] + Data._partListPostfix[2],
			Data._partListPrefix[3] + Data._partListPostfix[3],
			Data._partListPrefix[4] + Data._partListPostfix[4],
			Data._partListPrefix[5] + Data._partListPostfix[5],
			Data._partListPrefix[6] + Data._partListPostfix[6],
			Data._partListPrefix[7] + Data._partListPostfix[7],
			Data._partListPrefix[8] + Data._partListPostfix[8],
			Data._partListPrefix[9] + Data._partListPostfix[9],
			Data._partListPrefix[10] + Data._partListPostfix[10],
			Data._partListPrefix[11] + Data._partListPostfix[11],
			Data._partListPrefix[12] + Data._partListPostfix[12],
			Data._partListPrefix[13] + Data._partListPostfix[13],
			Data._partListPrefix[14] + Data._partListPostfix[14],
			Data._partListPrefix[15] + Data._partListPostfix[15],
			Data._partListPrefix[16] + Data._partListPostfix[16],
			Data._partListPrefix[17] + Data._partListPostfix[17],
			Data._partListPrefix[18] + Data._partListPostfix[18],
			Data._partListPrefix[19] + Data._partListPostfix[19] };

	/**
	 * All the option sets
	 */
	private static ArrayList<SinglePart> appVer, pipeO, procConnOrifice, seal,
			inletEdgeOrifice, ventDrain, diffPresConnSeal, condensChamMatVolPN,
			fillingCapCondensCham, inCondensCham, outCondensCham,
			shutOffValveGasket, matShutOffValve, inShutOffValve,
			outShutOffValve, manifoldVer, gasketManifold, procConnManifold,
			sealManifoldScrews, dpTransmitterDeltabar;

	/**
	 * All the namelists of option sets
	 */
	private static String[] appVerList, pipeOList, procConnOrificeList,
			sealList, inletEdgeOrificeList, ventDrainList,
			diffPresConnSealList, condensChamMatVolPNList,
			fillingCapCondensChamList, inCondensChamList, outCondensChamList,
			shutOffValveGasketList, matShutOffValveList, inShutOffValveList,
			outShutOffValveList, manifoldVerList, gasketManifoldList,
			procConnManifoldList, sealManifoldScrewsList,
			dpTransmitterDeltabarList;

	/**
	 * @param part
	 * 
	 *            Clear the disabler to the state that the part'th part is the
	 *            last part configured
	 */
	public static void clearDisablerFrom(final int part) {
		for (int i = part; i < 20; i++) {
			Data.disabler.get(i).clear();
		}
	}

	/**
	 * Initialize all the variables.
	 */
	public static void initAllVariables() {

		Data.initDisabler();

		Data.initAppVer();
		Data.initPipeO();
		Data.initProcConnOrifice();
		Data.initSeal();
		Data.initInletEdgeOrifice();
		Data.initVentDrain();
		Data.initDiffPresConnSeal();
		Data.initCondensChamMatVolPN();
		Data.initFillingCapCondensCham();
		Data.initInCondensCham();
		Data.initOutCondensCham();
		Data.initShutOffValveGasket();
		Data.initMatShutOffValve();
		Data.initInShutOffValve();
		Data.initOutShutOffValve();
		Data.initMatShutOffValve();
		Data.initManifoldVer();
		Data.initGasketManifold();
		Data.initProcConnManifold();
		Data.initSealManifoldScrews();
		Data.initDpTransmitterDeltabar();

		Data.initDatabase();
		Data.initLists();
	}

	/**
	 * Refresh lists based on current selections
	 */
	public static void refreshLists() {
		for (int i = 0; i < Data.database.size(); i++) {
			for (int j = 0; j < Data.database.get(i).size(); j++) {
				for (int k = 0; k < Data.disabler.size(); k++) {
					final int IPLUS = i + 1;
					if (Data.disabler.get(k).contains(
							(IPLUS + Messages.getString("Data.40") + Data.database.get(i).get(j) //$NON-NLS-1$
									.getCode()))) {
						if (view.MainWindow.isDebug()) {
							System.out.println(Messages.getString("Data.41") + IPLUS + Messages.getString("Data.42") //$NON-NLS-1$ //$NON-NLS-2$
									+ Data.database.get(i).get(j).getCode());
						}
						Data.lists.get(i)[j] = Messages.getString("Data.43") + Messages.getString("Data.44") //$NON-NLS-1$ //$NON-NLS-2$
								+ Data.database.get(i).get(j).getName();
						break;
					} else {
						Data.lists.get(i)[j] = Data.database.get(i).get(j)
								.getCode()
								+ Messages.getString("Data.45") + Data.database.get(i).get(j).getName(); //$NON-NLS-1$
					}
				}
			}
		}
	}

	/**
	 * @param currentPart
	 * 
	 *            Refresh list of parts based on current part
	 */
	public static void refreshPartList(final int currentPart) {
		for (int i = 0; i < Data.partList.length; i++) {
			Data.partList[i] = i <= currentPart ? Messages.getString("Data.46") //$NON-NLS-1$
					+ Data._partListPostfix[i] : Data._partListPrefix[i]
					+ Data._partListPostfix[i];
		}
	}

	/**
	 * @param srcPart
	 * @param part_option
	 * @return operation successful or not
	 * 
	 *         Set new restrictions based on the current selection
	 */
	public static boolean setDisabler(final int srcPart,
			final String part_option) {
		return Data.disabler.get(srcPart).add(part_option);
	}

	private static void initAppVer() {
		Data.appVer = new ArrayList<SinglePart>();
		Data.appVer.add(new model.Application_Version(Messages.getString("Data.47"), Messages.getString("Data.48"), Messages.getString("Data.49"), 0)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Data.appVer
				.add(new model.Application_Version(Messages.getString("Data.50"), Messages.getString("Data.51"), Messages.getString("Data.52"), 0)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Data.appVer.add(new model.Application_Version(Messages.getString("Data.53"), Messages.getString("Data.54"), Messages.getString("Data.55"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				0));
		Data.appVer.add(new model.Application_Version(Messages.getString("Data.56"), Messages.getString("Data.57"), Messages.getString("Data.58"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				0));
		Data.appVer
				.add(new model.Application_Version(Messages.getString("Data.59"), Messages.getString("Data.60"), Messages.getString("Data.61"), 0)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Data.appVer.add(new model.Application_Version(Messages.getString("Data.62"), Messages.getString("Data.63"), Messages.getString("Data.64"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				0));
		Data.appVer.add(new model.Application_Version(Messages.getString("Data.65"), //$NON-NLS-1$
				Messages.getString("Data.66"), Messages.getString("Data.67"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.appVerList = new String[Data.appVer.size()];
	}

	private static void initCondensChamMatVolPN() {
		Data.condensChamMatVolPN = new ArrayList<SinglePart>();
		Data.condensChamMatVolPN.add(new model.SinglePart(Messages.getString("Data.68"), Messages.getString("Data.69"), //$NON-NLS-1$ //$NON-NLS-2$
				0));
		Data.condensChamMatVolPN.add(new model.SinglePart(
				Messages.getString("Data.70"), Messages.getString("Data.71"), 3470)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.condensChamMatVolPN.add(new model.SinglePart(
				Messages.getString("Data.72"), Messages.getString("Data.73"), 7040)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.condensChamMatVolPN.add(new model.SinglePart(
				Messages.getString("Data.74"), Messages.getString("Data.75"), 7230)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.condensChamMatVolPN.add(new model.SinglePart(
				Messages.getString("Data.76"), Messages.getString("Data.77"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.condensChamMatVolPNList = new String[Data.condensChamMatVolPN
				.size()];
	}

	private static void initDatabase() {
		Data.database = new ArrayList<ArrayList<SinglePart>>();
		Data.database.ensureCapacity(20);
		Data.database.add(Data.appVer);
		Data.database.add(Data.pipeO);
		Data.database.add(Data.procConnOrifice);
		Data.database.add(Data.seal);
		Data.database.add(Data.inletEdgeOrifice);
		Data.database.add(Data.ventDrain);
		Data.database.add(Data.diffPresConnSeal);
		Data.database.add(Data.condensChamMatVolPN);
		Data.database.add(Data.fillingCapCondensCham);
		Data.database.add(Data.inCondensCham);
		Data.database.add(Data.outCondensCham);
		Data.database.add(Data.shutOffValveGasket);
		Data.database.add(Data.matShutOffValve);
		Data.database.add(Data.inShutOffValve);
		Data.database.add(Data.outShutOffValve);
		Data.database.add(Data.manifoldVer);
		Data.database.add(Data.gasketManifold);
		Data.database.add(Data.procConnManifold);
		Data.database.add(Data.sealManifoldScrews);
		Data.database.add(Data.dpTransmitterDeltabar);
	}

	private static void initDiffPresConnSeal() {
		Data.diffPresConnSeal = new ArrayList<SinglePart>();
		Data.diffPresConnSeal
				.add(new model.SinglePart(Messages.getString("Data.78"), Messages.getString("Data.79"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.diffPresConnSeal
				.add(new model.SinglePart(Messages.getString("Data.80"), Messages.getString("Data.81"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.diffPresConnSeal.add(new model.SinglePart(
				Messages.getString("Data.82"), Messages.getString("Data.83"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.diffPresConnSeal.add(new model.SinglePart(
				Messages.getString("Data.84"), Messages.getString("Data.85"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.diffPresConnSeal.add(new model.SinglePart(Messages.getString("Data.86"), Messages.getString("Data.87"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.diffPresConnSeal.add(new model.SinglePart(
				Messages.getString("Data.88"), Messages.getString("Data.89"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.diffPresConnSeal.add(new model.SinglePart(Messages.getString("Data.90"), //$NON-NLS-1$
				Messages.getString("Data.91"), 0)); //$NON-NLS-1$
		Data.diffPresConnSeal.add(new model.SinglePart(Messages.getString("Data.92"), //$NON-NLS-1$
				Messages.getString("Data.93"), 0)); //$NON-NLS-1$
		Data.diffPresConnSeal.add(new model.SinglePart(
				Messages.getString("Data.94"), Messages.getString("Data.95"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.diffPresConnSeal.add(new model.SinglePart(
				Messages.getString("Data.96"), Messages.getString("Data.97"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.diffPresConnSeal.add(new model.SinglePart(
				Messages.getString("Data.98"), Messages.getString("Data.99"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.diffPresConnSealList = new String[Data.diffPresConnSeal.size()];
	}

	private static void initDisabler() {
		Data.disabler = new ArrayList<Set<String>>();
		Data.disabler.ensureCapacity(20);
		if (view.MainWindow.isDebug()) {
			System.out.println(Data.disabler.size());
		}
		for (int i = 0; i < 20; i++) {
			Data.disabler.add(new HashSet<String>());
			Data.disabler.get(i).clear();
		}
	}

	private static void initDpTransmitterDeltabar() {
		Data.dpTransmitterDeltabar = new ArrayList<SinglePart>();
		Data.dpTransmitterDeltabar.add(new model.SinglePart(
				Messages.getString("Data.100"), Messages.getString("Data.101"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.dpTransmitterDeltabar.add(new model.SinglePart(Messages.getString("Data.102"), //$NON-NLS-1$
				Messages.getString("Data.103"), 0)); //$NON-NLS-1$

		Data.dpTransmitterDeltabarList = new String[Data.dpTransmitterDeltabar
				.size()];
	}

	private static void initFillingCapCondensCham() {
		Data.fillingCapCondensCham = new ArrayList<SinglePart>();
		Data.fillingCapCondensCham.add(new model.SinglePart(Messages.getString("Data.104"), //$NON-NLS-1$
				Messages.getString("Data.105"), 0)); //$NON-NLS-1$
		Data.fillingCapCondensCham
				.add(new model.SinglePart(Messages.getString("Data.106"), Messages.getString("Data.107"), 960)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.fillingCapCondensCham.add(new model.SinglePart(
				Messages.getString("Data.108"), Messages.getString("Data.109"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.fillingCapCondensChamList = new String[Data.fillingCapCondensCham
				.size()];
	}

	private static void initGasketManifold() {
		Data.gasketManifold = new ArrayList<SinglePart>();
		Data.gasketManifold.add(new model.SinglePart(Messages.getString("Data.110"), Messages.getString("Data.111"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.gasketManifold.add(new model.SinglePart(Messages.getString("Data.112"), Messages.getString("Data.113"), //$NON-NLS-1$ //$NON-NLS-2$
				0));
		Data.gasketManifold.add(new model.SinglePart(Messages.getString("Data.114"), //$NON-NLS-1$
				Messages.getString("Data.115"), 425)); //$NON-NLS-1$
		Data.gasketManifold.add(new model.SinglePart(
				Messages.getString("Data.116"), Messages.getString("Data.117"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.gasketManifoldList = new String[Data.gasketManifold.size()];
	}

	private static void initInCondensCham() {
		Data.inCondensCham = new ArrayList<SinglePart>();
		Data.inCondensCham.add(new model.SinglePart(Messages.getString("Data.118"), Messages.getString("Data.119"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inCondensCham.add(new model.SinglePart(Messages.getString("Data.120"), //$NON-NLS-1$
				Messages.getString("Data.121"), 0)); //$NON-NLS-1$
		Data.inCondensCham.add(new model.SinglePart(
				Messages.getString("Data.122"), Messages.getString("Data.123"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inCondensCham.add(new model.SinglePart(
				Messages.getString("Data.124"), Messages.getString("Data.125"), 1640)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inCondensCham.add(new model.SinglePart(
				Messages.getString("Data.126"), Messages.getString("Data.127"), 4650)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inCondensCham.add(new model.SinglePart(
				Messages.getString("Data.128"), Messages.getString("Data.129"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.inCondensChamList = new String[Data.inCondensCham.size()];
	}

	private static void initInletEdgeOrifice() {
		Data.inletEdgeOrifice = new ArrayList<SinglePart>();
		Data.inletEdgeOrifice
				.add(new model.SinglePart(Messages.getString("Data.130"), Messages.getString("Data.131"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inletEdgeOrifice.add(new model.SinglePart(
				Messages.getString("Data.132"), Messages.getString("Data.133"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inletEdgeOrifice.add(new model.SinglePart(Messages.getString("Data.134"), //$NON-NLS-1$
				Messages.getString("Data.135"), 0)); //$NON-NLS-1$
		Data.inletEdgeOrifice
				.add(new model.SinglePart(Messages.getString("Data.136"), Messages.getString("Data.137"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inletEdgeOrifice.add(new model.SinglePart(
				Messages.getString("Data.138"), Messages.getString("Data.139"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.inletEdgeOrificeList = new String[Data.inletEdgeOrifice.size()];
	}

	private static void initInShutOffValve() {
		Data.inShutOffValve = new ArrayList<SinglePart>();
		Data.inShutOffValve.add(new model.SinglePart(Messages.getString("Data.140"), Messages.getString("Data.141"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inShutOffValve.add(new model.SinglePart(Messages.getString("Data.142"), Messages.getString("Data.143"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inShutOffValve.add(new model.SinglePart(Messages.getString("Data.144"), Messages.getString("Data.145"), 1200)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inShutOffValve.add(new model.SinglePart(Messages.getString("Data.146"), //$NON-NLS-1$
				Messages.getString("Data.147"), 1340)); //$NON-NLS-1$
		Data.inShutOffValve.add(new model.SinglePart(
				Messages.getString("Data.148"), Messages.getString("Data.149"), 2200)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inShutOffValve.add(new model.SinglePart(
				Messages.getString("Data.150"), Messages.getString("Data.151"), 4730)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.inShutOffValve.add(new model.SinglePart(
				Messages.getString("Data.152"), Messages.getString("Data.153"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.inShutOffValveList = new String[Data.inShutOffValve.size()];
	}

	private static void initLists() {
		Data.lists = new ArrayList<String[]>();
		Data.lists.ensureCapacity(20);
		Data.lists.add(Data.appVerList);
		Data.lists.add(Data.pipeOList);
		Data.lists.add(Data.procConnOrificeList);
		Data.lists.add(Data.sealList);
		Data.lists.add(Data.inletEdgeOrificeList);
		Data.lists.add(Data.ventDrainList);
		Data.lists.add(Data.diffPresConnSealList);
		Data.lists.add(Data.condensChamMatVolPNList);
		Data.lists.add(Data.fillingCapCondensChamList);
		Data.lists.add(Data.inCondensChamList);
		Data.lists.add(Data.outCondensChamList);
		Data.lists.add(Data.shutOffValveGasketList);
		Data.lists.add(Data.matShutOffValveList);
		Data.lists.add(Data.inShutOffValveList);
		Data.lists.add(Data.outShutOffValveList);
		Data.lists.add(Data.manifoldVerList);
		Data.lists.add(Data.gasketManifoldList);
		Data.lists.add(Data.procConnManifoldList);
		Data.lists.add(Data.sealManifoldScrewsList);
		Data.lists.add(Data.dpTransmitterDeltabarList);
		Data.refreshLists();
	}

	private static void initManifoldVer() {
		Data.manifoldVer = new ArrayList<SinglePart>();
		Data.manifoldVer.add(new model.SinglePart(Messages.getString("Data.154"), Messages.getString("Data.155"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.manifoldVer.add(new model.SinglePart(Messages.getString("Data.156"), //$NON-NLS-1$
				Messages.getString("Data.157"), 1830)); //$NON-NLS-1$
		Data.manifoldVer.add(new model.SinglePart(Messages.getString("Data.158"), //$NON-NLS-1$
				Messages.getString("Data.159"), 3330)); //$NON-NLS-1$
		Data.manifoldVer.add(new model.SinglePart(Messages.getString("Data.160"), //$NON-NLS-1$
				Messages.getString("Data.161"), 2750)); //$NON-NLS-1$
		Data.manifoldVer.add(new model.SinglePart(Messages.getString("Data.162"), //$NON-NLS-1$
				Messages.getString("Data.163"), 3240)); //$NON-NLS-1$
		Data.manifoldVer.add(new model.SinglePart(
				Messages.getString("Data.164"), Messages.getString("Data.165"), 4200)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.manifoldVer.add(new model.SinglePart(
				Messages.getString("Data.166"), Messages.getString("Data.167"), 4920)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.manifoldVer.add(new model.SinglePart(
				Messages.getString("Data.168"), Messages.getString("Data.169"), 3060)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.manifoldVer.add(new model.SinglePart(
				Messages.getString("Data.170"), Messages.getString("Data.171"), 6060)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.manifoldVer.add(new model.SinglePart(
				Messages.getString("Data.172"), Messages.getString("Data.173"), 9010)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.manifoldVer.add(new model.SinglePart(
				Messages.getString("Data.174"), Messages.getString("Data.175"), 12410)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.manifoldVer.add(new model.SinglePart(
				Messages.getString("Data.176"), Messages.getString("Data.177"), 2830)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.manifoldVer.add(new model.SinglePart(
				Messages.getString("Data.178"), Messages.getString("Data.179"), 3320)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.manifoldVer.add(new model.SinglePart(
				Messages.getString("Data.180"), Messages.getString("Data.181"), //$NON-NLS-1$ //$NON-NLS-2$
				6150));
		Data.manifoldVer.add(new model.SinglePart(
				Messages.getString("Data.182"), Messages.getString("Data.183"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.manifoldVerList = new String[Data.manifoldVer.size()];
	}

	private static void initMatShutOffValve() {
		Data.matShutOffValve = new ArrayList<SinglePart>();
		Data.matShutOffValve.add(new model.SinglePart(Messages.getString("Data.184"), Messages.getString("Data.185"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.matShutOffValve.add(new model.SinglePart(Messages.getString("Data.186"), Messages.getString("Data.187"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.matShutOffValve.add(new model.SinglePart(Messages.getString("Data.188"), Messages.getString("Data.189"), 890)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.matShutOffValve.add(new model.SinglePart(Messages.getString("Data.190"), Messages.getString("Data.191"), 3440)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.matShutOffValve.add(new model.SinglePart(
				Messages.getString("Data.192"), Messages.getString("Data.193"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.matShutOffValveList = new String[Data.matShutOffValve.size()];
	}

	private static void initOutCondensCham() {
		Data.outCondensCham = new ArrayList<SinglePart>();
		Data.outCondensCham.add(new model.SinglePart(Messages.getString("Data.194"), Messages.getString("Data.195"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.outCondensCham.add(new model.SinglePart(Messages.getString("Data.196"), //$NON-NLS-1$
				Messages.getString("Data.197"), 0)); //$NON-NLS-1$
		Data.outCondensCham.add(new model.SinglePart(
				Messages.getString("Data.198"), Messages.getString("Data.199"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.outCondensCham.add(new model.SinglePart(Messages.getString("Data.200"), Messages.getString("Data.201"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.outCondensCham.add(new model.SinglePart(Messages.getString("Data.202"), Messages.getString("Data.203"), //$NON-NLS-1$ //$NON-NLS-2$
				0));
		Data.outCondensCham.add(new model.SinglePart(Messages.getString("Data.204"), Messages.getString("Data.205"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.outCondensCham.add(new model.SinglePart(Messages.getString("Data.206"), Messages.getString("Data.207"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.outCondensCham.add(new model.SinglePart(
				Messages.getString("Data.208"), Messages.getString("Data.209"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.outCondensChamList = new String[Data.outCondensCham.size()];
	}

	private static void initOutShutOffValve() {
		Data.outShutOffValve = new ArrayList<SinglePart>();
		Data.outShutOffValve.add(new model.SinglePart(Messages.getString("Data.210"), Messages.getString("Data.211"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.outShutOffValve.add(new model.SinglePart(
				Messages.getString("Data.212"), Messages.getString("Data.213"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.outShutOffValve.add(new model.SinglePart(Messages.getString("Data.214"), Messages.getString("Data.215"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.outShutOffValve.add(new model.SinglePart(Messages.getString("Data.216"), //$NON-NLS-1$
				Messages.getString("Data.217"), 0)); //$NON-NLS-1$
		Data.outShutOffValve.add(new model.SinglePart(
				Messages.getString("Data.218"), Messages.getString("Data.219"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.outShutOffValveList = new String[Data.outShutOffValve.size()];
	}

	private static void initPipeO() {
		Data.pipeO = new ArrayList<SinglePart>();
		Data.pipeO.add(new model.SinglePart(Messages.getString("Data.220"), Messages.getString("Data.221"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.pipeO.add(new model.SinglePart(Messages.getString("Data.222"), Messages.getString("Data.223"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.pipeO.add(new model.SinglePart(Messages.getString("Data.224"), //$NON-NLS-1$
				Messages.getString("Data.225"), 0)); //$NON-NLS-1$
		Data.pipeO.add(new model.SinglePart(
				Messages.getString("Data.226"), Messages.getString("Data.227"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.pipeO.add(new model.SinglePart(Messages.getString("Data.228"), Messages.getString("Data.229"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.pipeO.add(new model.SinglePart(Messages.getString("Data.230"), Messages.getString("Data.231"), //$NON-NLS-1$ //$NON-NLS-2$
				0));
		Data.pipeO.add(new model.SinglePart(Messages.getString("Data.232"), Messages.getString("Data.233"), //$NON-NLS-1$ //$NON-NLS-2$
				0));
		Data.pipeO.add(new model.SinglePart(Messages.getString("Data.234"), //$NON-NLS-1$
				Messages.getString("Data.235"), 0)); //$NON-NLS-1$
		Data.pipeO.add(new model.SinglePart(Messages.getString("Data.236"), //$NON-NLS-1$
				Messages.getString("Data.237"), 0)); //$NON-NLS-1$
		Data.pipeO.add(new model.SinglePart(
				Messages.getString("Data.238"), Messages.getString("Data.239"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.pipeO.add(new model.SinglePart(
				Messages.getString("Data.240"), Messages.getString("Data.241"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.pipeO.add(new model.SinglePart(
				Messages.getString("Data.242"), Messages.getString("Data.243"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.pipeOList = new String[Data.pipeO.size()];
	}

	private static void initProcConnManifold() {
		Data.procConnManifold = new ArrayList<SinglePart>();
		Data.procConnManifold.add(new model.SinglePart(Messages.getString("Data.244"), Messages.getString("Data.245"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.procConnManifold.add(new model.SinglePart(Messages.getString("Data.246"), Messages.getString("Data.247"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.procConnManifold.add(new model.SinglePart(
				Messages.getString("Data.248"), Messages.getString("Data.249"), 390)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.procConnManifold.add(new model.SinglePart(Messages.getString("Data.250"), //$NON-NLS-1$
				Messages.getString("Data.251"), 390)); //$NON-NLS-1$
		Data.procConnManifold.add(new model.SinglePart(Messages.getString("Data.252"), Messages.getString("Data.253"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.procConnManifold.add(new model.SinglePart(
				Messages.getString("Data.254"), Messages.getString("Data.255"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.procConnManifoldList = new String[Data.procConnManifold.size()];
	}

	private static void initProcConnOrifice() {
		Data.procConnOrifice = new ArrayList<SinglePart>();
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.256"), //$NON-NLS-1$
				Messages.getString("Data.257"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.258"), //$NON-NLS-1$
				Messages.getString("Data.259"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.260"), //$NON-NLS-1$
				Messages.getString("Data.261"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.262"), //$NON-NLS-1$
				Messages.getString("Data.263"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.264"), //$NON-NLS-1$
				Messages.getString("Data.265"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.266"), //$NON-NLS-1$
				Messages.getString("Data.267"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.268"), //$NON-NLS-1$
				Messages.getString("Data.269"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.270"), //$NON-NLS-1$
				Messages.getString("Data.271"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.272"), //$NON-NLS-1$
				Messages.getString("Data.273"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.274"), //$NON-NLS-1$
				Messages.getString("Data.275"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.276"), //$NON-NLS-1$
				Messages.getString("Data.277"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.278"), //$NON-NLS-1$
				Messages.getString("Data.279"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.280"), //$NON-NLS-1$
				Messages.getString("Data.281"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.282"), //$NON-NLS-1$
				Messages.getString("Data.283"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.284"), //$NON-NLS-1$
				Messages.getString("Data.285"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.286"), //$NON-NLS-1$
				Messages.getString("Data.287"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.288"), //$NON-NLS-1$
				Messages.getString("Data.289"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.290"), //$NON-NLS-1$
				Messages.getString("Data.291"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.292"), //$NON-NLS-1$
				Messages.getString("Data.293"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.294"), //$NON-NLS-1$
				Messages.getString("Data.295"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.296"), //$NON-NLS-1$
				Messages.getString("Data.297"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.298"), //$NON-NLS-1$
				Messages.getString("Data.299"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.300"), //$NON-NLS-1$
				Messages.getString("Data.301"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.302"), //$NON-NLS-1$
				Messages.getString("Data.303"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.304"), //$NON-NLS-1$
				Messages.getString("Data.305"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(Messages.getString("Data.306"), //$NON-NLS-1$
				Messages.getString("Data.307"), 0)); //$NON-NLS-1$
		Data.procConnOrifice.add(new model.SinglePart(
				Messages.getString("Data.308"), Messages.getString("Data.309"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.procConnOrifice.add(new model.SinglePart(
				Messages.getString("Data.310"), Messages.getString("Data.311"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.procConnOrifice.add(new model.SinglePart(
				Messages.getString("Data.312"), Messages.getString("Data.313"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.procConnOrifice.add(new model.SinglePart(
				Messages.getString("Data.314"), Messages.getString("Data.315"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.procConnOrifice.add(new model.SinglePart(
				Messages.getString("Data.316"), Messages.getString("Data.317"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.procConnOrificeList = new String[Data.procConnOrifice.size()];
	}

	private static void initSeal() {
		Data.seal = new ArrayList<SinglePart>();
		Data.seal.add(new model.SinglePart(Messages.getString("Data.318"), Messages.getString("Data.319"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.seal.add(new model.SinglePart(Messages.getString("Data.320"), Messages.getString("Data.321"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.seal.add(new model.SinglePart(
				Messages.getString("Data.322"), Messages.getString("Data.323"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.sealList = new String[Data.seal.size()];
	}

	private static void initSealManifoldScrews() {
		Data.sealManifoldScrews = new ArrayList<SinglePart>();
		Data.sealManifoldScrews.add(new model.SinglePart(Messages.getString("Data.324"), Messages.getString("Data.325"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.sealManifoldScrews.add(new model.SinglePart(
				Messages.getString("Data.326"), Messages.getString("Data.327"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.sealManifoldScrews.add(new model.SinglePart(
				Messages.getString("Data.328"), Messages.getString("Data.329"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.sealManifoldScrews.add(new model.SinglePart(
				Messages.getString("Data.330"), Messages.getString("Data.331"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.sealManifoldScrews.add(new model.SinglePart(
				Messages.getString("Data.332"), Messages.getString("Data.333"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.sealManifoldScrews.add(new model.SinglePart(
				Messages.getString("Data.334"), Messages.getString("Data.335"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.sealManifoldScrews.add(new model.SinglePart(
				Messages.getString("Data.336"), Messages.getString("Data.337"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.sealManifoldScrewsList = new String[Data.sealManifoldScrews.size()];
	}

	private static void initShutOffValveGasket() {
		Data.shutOffValveGasket = new ArrayList<SinglePart>();
		Data.shutOffValveGasket
				.add(new model.SinglePart(Messages.getString("Data.338"), Messages.getString("Data.339"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.shutOffValveGasket.add(new model.SinglePart(
				Messages.getString("Data.340"), Messages.getString("Data.341"), 1050)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.shutOffValveGasket.add(new model.SinglePart(
				Messages.getString("Data.342"), Messages.getString("Data.343"), 1050)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.shutOffValveGasket.add(new model.SinglePart(
				Messages.getString("Data.344"), Messages.getString("Data.345"), 1050)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.shutOffValveGasket.add(new model.SinglePart(
				Messages.getString("Data.346"), Messages.getString("Data.347"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.shutOffValveGasketList = new String[Data.shutOffValveGasket.size()];
	}

	private static void initVentDrain() {
		Data.ventDrain = new ArrayList<SinglePart>();
		Data.ventDrain.add(new model.SinglePart(Messages.getString("Data.348"), Messages.getString("Data.349"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.ventDrain.add(new model.SinglePart(Messages.getString("Data.350"), Messages.getString("Data.351"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.ventDrain.add(new model.SinglePart(Messages.getString("Data.352"), Messages.getString("Data.353"), 0)); //$NON-NLS-1$ //$NON-NLS-2$
		Data.ventDrain.add(new model.SinglePart(
				Messages.getString("Data.354"), Messages.getString("Data.355"), 0)); //$NON-NLS-1$ //$NON-NLS-2$

		Data.ventDrainList = new String[Data.ventDrain.size()];
	}

}