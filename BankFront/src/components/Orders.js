import React, { useEffect, useState } from 'react';
import Link from '@mui/material/Link';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Title from './Title';
import axios from 'axios';

const Orders = () => {
  const [transactions, setTransactions] = useState([]);

  useEffect(() => {
    const fetchTransactions = async () => {
      try {
        const response = await axios.get('http://localhost:8081/transactions');
        setTransactions(response.data);
      } catch (error) {
        console.error('Error fetching transactions:', error);
      }
    };

    fetchTransactions();
  }, []);

  return (
    <React.Fragment>
      <Title>Personal</Title>
      <Table size="small">
        <TableHead>
          <TableRow>
            <TableCell>Photo</TableCell>
            <TableCell>Description</TableCell>
            <TableCell>Amount</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {transactions.map((row) => (
            <TableRow key={row.id}>
              <TableCell>{row.photo}</TableCell>
              <TableCell>{row.description}</TableCell>
              <TableCell>{row.amount}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
      <Link color="primary" href="#" onClick={(event) => event.preventDefault()} sx={{ mt: 3 }}>
        See more orders
      </Link>
    </React.Fragment>
  );
};

export default Orders;

// Generate Order Data
// function createData(id, photo, transactionDesciption, amount) {
//   return {id, photo, transactionDesciption, amount};
// }

// const rows = [
//   createData(
//     0,
//     'photo',
//     'Kenya paid Cristina',
//     '-$234'
//   ),
//   createData(
//     1,
//     'photo',
//     'Maria paid Kenya',
//     '+$104'
//   ),
//   createData(
//     3,
//     'photo',
//     'Kenya paid Maria',
//     '-$2'
//   )
// ];

// function preventDefault(event) {
//   event.preventDefault();
// }

// export default function Orders() {
//   return (
//     <React.Fragment>
//       <Title>Personal</Title>
//       <Table size="small">
//         {/* <TableHead>
//           <TableRow>
//             <TableCell>Photo</TableCell>
//             <TableCell>Description</TableCell>
//             <TableCell align="right">Amount</TableCell>
//           </TableRow>
//         </TableHead> */}
//         <TableBody>
//           {rows.map((row) => (
//             <TableRow key={row.id}>
//               <TableCell>{row.photo}</TableCell>
//               <TableCell>{row.transactionDesciption}</TableCell>
//               <TableCell align="right">{`${row.amount}`}</TableCell>
//             </TableRow>
//           ))}
//         </TableBody>
//       </Table>
//       <Link color="primary" href="#" onClick={preventDefault} sx={{ mt: 3 }}>
//         See more orders
//       </Link>
//     </React.Fragment>
//   );
// }
