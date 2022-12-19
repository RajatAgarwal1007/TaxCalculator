import { User } from './user';

export class Tax {
  id: number = 0;
  user: User = new User();
  amount: number | undefined;
  zoneId: number | undefined;
  stateId: number | undefined;
  calculatedTax: number | undefined;
}
