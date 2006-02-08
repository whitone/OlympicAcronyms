/*  Olympic Acronyms 0.1
 *
 *  Copyright (C) 2006 Stefano Cotta Ramusino
 *  All Rights Reserved.
 *
 *  The OlympicAcronyms midlet is free software; you can redistribute 
 *  it and/or modify it under the terms of the GNU General Public 
 *  License as published by the Free Software Foundation; either 
 *  version 2 of the License, or (at your option) any later version.
 *
 *  The OlympicAcronyms midlet is distributed in the hope that it will
 *  be useful, but WITHOUT ANY WARRANTY; without even the implied 
 *  warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with the OlympicAcronyms midlet; see the file COPYING.
 *  If not, write to the Free Software Foundation, Inc.,
 *  59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 */

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;


public class OlympicAcronyms extends MIDlet implements CommandListener {
	
	private List    list                       ;
	private Command aboutCommand , exitCommand ;
	private Alert   about                      ;
	private Display display                    ;
	

	public OlympicAcronyms() {

		String listtitle = "Torino 2006";
		String[] acronyms = {
			
				"ACR: Accreditation",
				"BA: Bardonecchia",
				"BDY: Bardonecchia",
				"BTP: Backbone Termination Point",
				"BTS: Base Transmitter Station",
				"CATV: Cable Television",
				"CE: Cesana",
				"CEP: Cesana Pariol",
				"CH: Val Chisone",
				"CHA: Champlas du Col and Champlas Janvier",
				"CIS: Commentator Information System",
				"CRS: Central Repository System",
				"CSS: Cesana San Sicario",
				"DCO: Doping Control Officer",
				"DOM: Dorsale Olimpica Montana",
				"DPC: Doping Control",
				"DTVM: Duty Telecom Volunteer Manager",
				"EVS: Event Services",
				"F&B: Food and Beverage",
				"FA: Functional Area",
				"FCC: Functional Command Center",
				"FOP: Field of Play",
				"GMS: Games Management System",
				"HD: Help Desk",
				"HTS: Ice Hockey Training Site",
				"HVAC: Heating, Ventilation and Air Conditioning",
				"IBC: International Broadcast Center",
				"ICMS: Info Contents Management System",
				"IF: International Federation",
				"IOC: International Olympic Committee",
				"IPC: International Paralympic Committee",
				"LOG: Logistic",
				"MAC: Main Accreditation Center",
				"MKT: Marketing",
				"MMC: Main Media Center",
				"MOC: Main Operations Center",
				"MPC: Main Press Center",
				"MTC: Main Technology Center",
				"MV: Media Village",
				"MVT: Media Village Torino",
				"NOCs: National Olympic Committees",
				"NPCs: National Paralympic Committees",
				"OF: Olympic Family",
				"OFH: Olympic Family Hotel",
				"OIAC: Olympic Identity and Accreditation Card",
				"OS: Oulx and Sauze d'Oulx",
				"OU: Oulx",
				"OVB: Olympic Village Bardonecchia",
				"OVL: Oval Lingotto",
				"OVR: On Venue Results",
				"OVS: Olympic Village Sestriere",
				"OVT: Olympic Village Torino",
				"PAL: Palavela",
				"PCS: Press Center Sestriere",
				"PCTS: Press Center Telecom Support",
				"PI: Pinerolo",
				"PIN: Pinerolo Palaghiaccio",
				"PF: Paralympic Family",
				"PFH: Paralympic Family Hotel",
				"PMC: Paralympic Media Center",
				"PML: Piazza delle Medaglie",
				"PMRS: Professional Mobile Radio Specialist",
				"PR: Pragelato",
				"PRA: Pragelato",
				"PRD: Print Distribution",
				"PRP: Pragelato Plan",
				"PRS: Press",
				"PRT: Protocol Team",
				"PSO: Palasport Olimpico",
				"PVS: Paralympic Village Sestriere",
				"RCTS: Rate Card Telecom Support",
				"RD: Radio Distribution",
				"RDO: Radio Distribution Operator",
				"SAT: Supporto Assistenza Totale",
				"SC: Sauze di Cesana",
				"SCB: Sestriere Colle and Borgata",
				"SDO: Sauze d'Oulx Jouvenceaux",
				"SE: Sestriere",
				"SEC: Security",
				"SPP: Sport Production",
				"SS: San Sicario",
				"SSA: San Sicario Alto",
				"SSB: San Sicario Borgo",
				"SSF: San Sicario Fraiteve",
				"STA: Stadio Olimpico",
				"STB: Sestriere sub-area Borgata",
				"STC: Sestriere sub-area Colle",
				"T&S: Timing and Results Area",
				"TEC: Technology",
				"TES: Torino Esposizioni",
				"TMA: Telecom Manager Assistant",
				"TOB: Broadcast",
				"TOBO: Broadcast Technical Manager",
				"TOC: Traffic Operation Centre",
				"TOROC: Torino Organising Committee XX Olympic Winter Games",
				"TPG: Torino Palaghiaccio",
				"TRA: Transport",
				"TRN: Torino International Airport",
				"TT: Telephones Technician",
				"TVS: Telecom Venue Support",
				"UDC: Uniform Distribution Center",
				"VCC: Venue Communication Center",
				"VDC: Venue Data Center",
				"VITM: Venue IT Manager",
				"VMC: Venue Media Center",
				"VOC: Venue Operational Center",
				"VOP: Venue Operator",
				"VPC: Vehicle Permit Check",
				"VRM: Venue Results Manager",
				"VTCM: Venue Telecom Manager",
				"VTM: Venue Technology Manager",
				"VTS: Venue Telecom Support",
				"VVM: Venue Volunteer Manager",
				"W&C: Waste and Cleaning",
				"WKF: Work Force"
				
		                     };
		
		String aboutlabel = "About" ;
		String exitlabel  = "Exit" ;
		
		aboutCommand = new Command(aboutlabel, Command.ITEM, 0);
		exitCommand = new Command(exitlabel, Command.EXIT, 1);
		
		list = new List(listtitle, List.IMPLICIT, acronyms, null);
		list.addCommand(exitCommand);
		list.addCommand(aboutCommand);
		list.setCommandListener(this);
		
		display = Display.getDisplay(this);
		
	}
	
	public void startApp() throws MIDletStateChangeException {

		display.setCurrent(list);
		
	}
	
	public void pauseApp() {
		
	}
	
	public void destroyApp(boolean unconditional) {

		list         = null ;
		aboutCommand = null ;
		exitCommand  = null ;
		about        = null ;
		display      = null ;
		
	}
	
	public void commandAction(Command cmd, Displayable d) {
		
		if (cmd == exitCommand) {
			
			destroyApp(true);
			notifyDestroyed();
			
		}

		if (cmd == aboutCommand) {

			about = new Alert("Olympic Acronyms",
			                  "Olympic Acronyms 0.1\n\nThe list of acronyms"
			                  + " of Olympic Winter Games of Torino 2006"
			                  + "\n\nReleased under the terms of GPL\n"
			                  + "Copyright (C) 2006 Stefano Cotta Ramusino",
			                  null,
			                  null);
			about.setTimeout(Alert.FOREVER);
			
			display.setCurrent(about, list);
			
		}
			
		
	}
	
}
