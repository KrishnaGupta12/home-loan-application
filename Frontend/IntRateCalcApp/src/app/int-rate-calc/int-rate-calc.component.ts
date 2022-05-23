import { Component, OnInit } from '@angular/core';
import { IRCService } from '../irc.service';
import { LoanInfo } from '../loan-info';

@Component({
  selector: 'app-int-rate-calc',
  templateUrl: './int-rate-calc.component.html',
  styleUrls: ['./int-rate-calc.component.css']
})
export class IntRateCalcComponent implements OnInit {

  info:any;

  
  constructor(private service:IRCService ) { 
    
  }
  

  ngOnInit(): void {
    
    }
    amount:number=0;
    tenure:number=0;
    bool =true;
    isValidFormSubmitted = false;


    flag=false;


    calculate(loanInfo:any)
    {
      this.isValidFormSubmitted = false;
     if (loanInfo.invalid) {
        return;
     }
     this.isValidFormSubmitted = true;
      
      this.info=loanInfo.value;

      this.info.salariedOrSelfEmployed=this.bool;
     //console.log(this.info.creditScore);


      this.service.calculate(this.info).subscribe(
        (data)=>{
          console.log(data);
          this.info = data;
          if(this.info.creditScore <301)
          {
            alert("You are not eligible for loan! as your credit score is poor.")
            
            
          }
          else{
            this.flag=true;
          }
          
        },
        (error)=>{
          console.log("Error **********************************")
          console.log(error);
        }        
      )
    }

}
