package com.mb.timetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mb.timetracker.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {}