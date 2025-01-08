"use client";

import React, { useEffect, useState } from 'react';
import { listTriages } from '../services/TriageService';

interface Triage {
  id: number;
  name: string;
  age: string;
  bloodPressure: string;
  heartRate: string;
  oxygenSaturation: string;
  description: string;
}

const Page: React.FC = () => {
  const [triages, setTriages] = useState<Triage[]>([]);

  useEffect(() => {
    listTriages()
      .then((data) => {
        setTriages(data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div>
      <h2>Queue</h2>
      <table>
        <thead>
          <tr>
            <th>Id</th>
            <th>Patient Name</th>
            <th>Age</th>
            <th>Blood Pressure</th>
            <th>Heart Rate</th>
            <th>Oxygen Saturation</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          {triages.map((triage) => (
            <tr key={triage.id}>
              <td>{triage.id}</td>
              <td>{triage.name}</td>
              <td>{triage.age}</td>
              <td>{triage.bloodPressure}</td>
              <td>{triage.heartRate}</td>
              <td>{triage.oxygenSaturation}</td>
              <td>{triage.description}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Page;