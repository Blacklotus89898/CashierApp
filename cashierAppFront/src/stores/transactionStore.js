// useTransactionStore.js
import { useReducer, createContext, useContext } from 'react';

// Define action types
const ADD_TRANSACTION = 'ADD_TRANSACTION';
const REMOVE_TRANSACTION = 'REMOVE_TRANSACTION';
const CLEAR_TRANSACTIONS = 'CLEAR_TRANSACTIONS';

// Define the initial state
const initialState = [];

// Define the reducer function
const transactionReducer = (state, action) => {
    switch (action.type) {
        case ADD_TRANSACTION:
            return [...state, action.payload];
        case REMOVE_TRANSACTION:
            return state.filter(transaction => transaction.id !== action.payload);
        case CLEAR_TRANSACTIONS:
            return [];
        default:
            return state;
    }
};

// Create a context
const TransactionContext = createContext();

// Create a custom hook to use the transaction store
export const useTransactionStore = () => {
    const context = useContext(TransactionContext);
    if (!context) {
        throw new Error('useTransactionStore must be used within a TransactionProvider');
    }
    return context;
};

// Create a provider component
export const TransactionProvider = ({ children }) => {
    const [state, dispatch] = useReducer(transactionReducer, initialState);

    const addTransaction = (transaction) => {
        dispatch({ type: ADD_TRANSACTION, payload: transaction });
    };

    const removeTransaction = (id) => {
        dispatch({ type: REMOVE_TRANSACTION, payload: id });
    };

    const clearTransactions = () => {
        dispatch({ type: CLEAR_TRANSACTIONS });
    };

    return (
        <TransactionContext.Provider value={{ state, addTransaction, removeTransaction, clearTransactions }}>
            {children}
        </TransactionContext.Provider>
    );
};