import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { Component, OnInit, Input } from '@angular/core';
import { UsersComponent } from '../users.component';

/**
 * Mostra i detagli di UserDTO
 */
@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent extends UsersComponent implements OnInit {
  @Input() dto = UserDTO;
  constructor(service: UserService) {
    super(service);
  }

  ngOnInit() {
  }

}
