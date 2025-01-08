"use client"
import Image from "next/image";
import Link from "next/link";

import { columns } from "@/components/queue/columns";
import { DataTable } from "@/components/queue/DataTable";
import { getRecentAppointmentList } from "@/lib/actions/appointment.actions";
import StatCard from "@/components/StatCard";
import { useEffect, useState } from "react";
import { ColumnDef } from "@tanstack/react-table";
import axios from 'axios';
import { listTriages } from "@/lib/actions/triage.actions";

interface Triage {
    id: number;
    name: string;
    age: string;
    bloodPressure: string;
    heartRate: string;
    oxygenSaturation: string;
    description: string;
  }
  
  const Queue = () => {
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
  
    const columns: ColumnDef<Triage, any>[] = [
      {
        accessorKey: 'id',
        header: 'Id',
      },
      {
        accessorKey: 'name',
        header: 'Patient Name',
      },
      {
        accessorKey: 'age',
        header: 'Age',
      },
      {
        accessorKey: 'bloodPressure',
        header: 'Blood Pressure',
      },
      {
        accessorKey: 'heartRate',
        header: 'Heart Rate',
      },
      {
        accessorKey: 'oxygenSaturation',
        header: 'Oxygen Saturation',
      },
      {
        accessorKey: 'description',
        header: 'Description',
      },
    ];
  return (
    <div className="mx-auto flex max-w-7xl flex-col space-y-14">
      <header className="admin-header">
        <Link href="/" className="cursor-pointer">
          <Image
            src="/assets/images/logo-full.png"
            height={32}
            width={162}
            alt="logo"
            className="h-8 w-fit"
          />
        </Link>
        <h1 className="text-blue-500 font-extrabold text-4xl">EHospital</h1>
        <p className="text-16-semibold">Admin Dashboard</p>
      </header>

      <main className="admin-main">
        <DataTable columns={columns} data={triages} />
      </main>
    </div>
  );
};

export default Queue;