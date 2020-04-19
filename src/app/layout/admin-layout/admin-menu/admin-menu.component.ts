import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})

export class AdminMenuComponent implements OnInit {

  isParkingplaceCollapsed = false;
  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isFloorCollapsed = false;
  isCarCollapsed = false;
  isPersonCollapsed=false;


  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  parkingplacescollapse() {
    if(this.isParkingplaceCollapsed == false) {
      this.isParkingplaceCollapsed = true;
    } else {this.isParkingplaceCollapsed = false; }

    }

  carscollapse() {
    if (this.isCarCollapsed === false) {
      this.isCarCollapsed = true;
    } else { this.isCarCollapsed = false; }
  }
  
  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }

  floorcollapse(){
    if(this.isFloorCollapsed === false){
      this.isFloorCollapsed = true;
    }
    else {
      this.isFloorCollapsed=false;
    }
  }
  personscollapse(){
    if(this.isPersonCollapsed===false){
      this.isPersonCollapsed=true;
    }else{
      this.isPersonCollapsed=false;
    }
  }
}
