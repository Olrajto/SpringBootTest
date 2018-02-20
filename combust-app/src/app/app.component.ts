import {Component, OnInit} from '@angular/core';
import {DataService} from "./DataService";
import {Observable} from "rxjs/Observable";
import { ChartsModule } from 'ng2-charts/ng2-charts';


@Component({
  selector: 'combust-main',
  templateUrl: './app.combustion.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  data: any[];

  public barChartOptions:any = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLabels:string[] = ['2011', '2012', '2013', '2014', '2015', '2016', '2017'];
  public barChartType:string = 'line';
  public barChartLegend:boolean = false;
  public barChartData:any[] = [
    {data: [66, 55, 83, 82, 56, 51, 43], label: 'Loss'},
    {data: [29, 38, 40, 21, 82, 30, 89], label: 'Profit'}
  ];
  public chartClicked(e:any):void {
    console.log(e);
  }

  // Chart events
  public chartHovered(e:any):void {
    console.log(e);
  }

  private combustionAll = 'combustion';

  constructor(private _dataService: DataService) {
  }

  ngOnInit(): void {
    this._dataService.getAll<any[]>(this.combustionAll).subscribe((data: any[]) => this.data = data,
      error1 => () => {
        console.log(error1, "Error while getting combustion data")
      },
      () => {

      });

  }

}
