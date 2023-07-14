import react from 'react';
import React, {useEffect, useState} from 'react';
import axios from 'axios';




const ListAccount = () => {
    const accounts = [
        {id:1, name: 'account 1', balance: 1000},
        {id:2, name: 'account 2', balance: 200},
        {id:3, name: 'account 3', balance: 5000},
    ];

    return (
        <div>
            <h2>List of account</h2>
            <ul>
                {accounts.map((account) => (
                    <li key={account.id}>
                        <span>{account.name}</span>
                        <span>{account.balance}</span>
                    </li>
                ))}
            </ul>
        </div>
    )
}

export default ListAccount;