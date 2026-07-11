package com.backend.Inventry_backend_application.serviceImpl;


import com.backend.Inventry_backend_application.common.PageResponse;
import com.backend.Inventry_backend_application.mapper.StockMvtMapper;
import com.backend.Inventry_backend_application.model.Product;
import com.backend.Inventry_backend_application.model.StockMvt;
import com.backend.Inventry_backend_application.repository.ProductRepository;
import com.backend.Inventry_backend_application.repository.StockMvtRepository;
import com.backend.Inventry_backend_application.request.StockMvtRequest;
import com.backend.Inventry_backend_application.response.StockMvtResponse;
import com.backend.Inventry_backend_application.service.StockMvtService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockMvtServiceImpl implements StockMvtService {

    private final StockMvtRepository stockMvtRepository;
    private final ProductRepository productRepository;
    private final StockMvtMapper stockMvtMapper;

    @Override
    public void create(final StockMvtRequest request) {
        // check if product exists
        checkIfProductExistsById(request.getProductId());

        final StockMvt entity = this.stockMvtMapper.toEntity(request);
        entity.setDateMvt(LocalDate.now());
        this.stockMvtRepository.save(entity);
    }

    @Override
    public void update(final String id, final StockMvtRequest request) {
        final Optional<StockMvt> stockMvt = this.stockMvtRepository.findById(id);
        if (stockMvt.isEmpty()) {
            log.debug("StockMvt does not exist");
            throw new EntityNotFoundException("StockMvt does not exist");
        }

        // check if product exists
        checkIfProductExistsById(request.getProductId());

        final StockMvt stockMvtToUpdate = this.stockMvtMapper.toEntity(request);
        stockMvtToUpdate.setDateMvt(LocalDate.now());
        stockMvtToUpdate.setId(id);
        this.stockMvtRepository.save(stockMvtToUpdate);
    }

    @Override
    public PageResponse<StockMvtResponse> findAll(final int page, final int size) {
        final PageRequest pageRequest = PageRequest.of(page, size);
        final Page<StockMvt> stockMvts = this.stockMvtRepository.findAll(pageRequest);
        final Page<StockMvtResponse> stockMvtResponses = stockMvts.map(this.stockMvtMapper::toResponse);
        return PageResponse.of(stockMvtResponses);
    }

    @Override
    public StockMvtResponse findById(final String id) {
        return this.stockMvtRepository.findById(id)
                                      .map(this.stockMvtMapper::toResponse)
                                      .orElseThrow(() -> new EntityNotFoundException("StockMvt does not exist"));
    }

    @Override
    public void delete(final String id) {
        final StockMvt stockMvt = this.stockMvtRepository.findById(id)
                                                         .orElseThrow(() -> new EntityNotFoundException("StockMvt does not exist"));
        this.stockMvtRepository.delete(stockMvt);

    }

    private void checkIfProductExistsById(final String productId) {
        final Optional<Product> product = this.productRepository.findById(productId);
        if (product.isEmpty()) {
            log.debug("Product does not exist");
            throw new EntityNotFoundException("Product does not exist");
        }
    }

    @Override
    public PageResponse<StockMvtResponse> findAllByProductId(final String productId, final int page, final int size) {
        final PageRequest pageRequest = PageRequest.of(page, size);
        final Page<StockMvt> stockMvts = this.stockMvtRepository.findAllByProductId(productId, (Pageable) pageRequest);
        final Page<StockMvtResponse> stockMvtResponses = stockMvts.map(this.stockMvtMapper::toResponse);
        return PageResponse.of(stockMvtResponses);
    }
}
