import { Component, OnInit } from '@angular/core';
import { IRCService } from '../irc.service';
import { LoanInfo } from '../loan-info';

@Component({
  selector: 'app-int-rate-calc',
  templateUrl: './int-rate-calc.component.html',
  styleUrls: ['./int-rate-calc.component.css']
})
export class IntRateCalcComponent implements OnInit {

  constructor(private service:IRCService ) { }
  

  ngOnInit(): void {
    this.info.salariedOrSelfEmployed=true;
    }

   
    info:any;
    flag=false;
  

    toggleToTrue()
    {
      this.info.salariedOrSelfEmployed=true;

    }

    toggleToFalse()
    {
      this.info.salariedOrSelfEmployed=false;

    }

    calculate(loanInfo:any)
    {
      
      this.info=loanInfo.value;
      this.info.salariedOrSelfEmployed=true;
     //console.log(this.info.creditScore);


      this.service.calculate(this.info).subscribe(
        (data)=>{
          console.log(data);
          this.info = data;
          this.flag=true;
        },
        (error)=>{
          console.log("Error **********************************")
          console.log(error);
        }
        
        
      )



    }

}
