import { useState } from "react";
import ReportService from "../services/ReportService";
import NoteService from "../services/NoteService";
import PaymentService from "../services/PaymentService";
import ProductService from "../services/ProductService";
import ProductTypeService from "../services/ProductTypeService";
import PromotionService from "../services/PromotionService";

const TestController = () => {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [query, setQuery] = useState("");
  const [content, setContent] = useState([]);

  const getContent = () => {
    setLoading(true);
    switch (query) {
        case "reports":
            ReportService.getAllReports()
                .then((response) => {
                    setContent(response.data);
                    setLoading(false);
                })
                .catch((error) => {
                    setError(error);
                    setLoading(false);
                });
            break;
        case "notes":
            NoteService.getAllNotes()
                .then((response) => {
                    setContent(response.data);
                    setLoading(false);
                })
                .catch((error) => {
                    setError(error);
                    setLoading(false);
                });
            break;
        case "payments":
            PaymentService.getAllPayments()
                .then((response) => {
                    setContent(response.data);
                    setLoading(false);
                })
                .catch((error) => {
                    setError(error);
                    setLoading(false);
                });
            break;
        case "products":
            ProductService.getAllProducts()
                .then((response) => {
                    setContent(response.data);
                    setLoading(false);
                })
                .catch((error) => {
                    setError(error);
                    setLoading(false);
                });
            break;
        case "productTypes":
            ProductTypeService.getAllProductTypes()
                .then((response) => {
                    setContent(response.data);
                    setLoading(false);
                })
                .catch((error) => {
                    setError(error);
                    setLoading(false);
                });
            break;
        case "promotions":
            PromotionService.getAllPromotions()
                .then((response) => {
                    setContent(response.data);
                    setLoading(false);
                })
                .catch((error) => {
                    setError(error);
                    setLoading(false);
                });
            break;
        default:
            setContent([]);
            setLoading(false);
    } 

  }



  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error.message}</div>;
  }

  return (
    <div>

        <h1>Test Controller</h1>
        <input type="text" value={query} onChange={(e) => setQuery(e.target.value)} />
        <button onClick={getContent}>Get Content</button>
        <ul>
            {content.map((item) => (
                <li key={item.id}>{item.id}</li>
            ))}
        </ul>
    </div>
  );
};

export default TestController;