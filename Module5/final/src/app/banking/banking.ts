import {Customer} from './customer';

export interface Banking {
  id: number;
  customer: Customer;
  dayOpen: string;
  dayStart: string;
  time: string;
  money: string;
  moneyFree: string;
  sale: string;
}
